This is code created during the November 2021 "Kontain Your Spring" workshop.

Thank you to all who attended. Here's a summary of how to build/deploy the code:

## Building and deploying

To simply build the image:

~~~
$ ./mvnw spring-boot:build-image
~~~

To override the configured image name, specify it at the command line like this:

~~~
$ ./mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=habume/hello-world:1.0.0
~~~

If in your project you are using Gradle, the equivalent would be:

~~~
$ ./gradlew bootBuildImage --imageName=habuma/hello-world:1.0.0
~~~

If you want to specify the image name in your build.gradle file, set it like this:

~~~
bootBuildImage {
  imageName = "habuma/${rootProject.name}:${version}"
}
~~~

Before deploying it, you'll need a cluster to deploy it to. If you're using Kind,
you can create a cluster like this:

~~~
$ kind create cluster --name=workshop
~~~

The easiest way to deploy is with Skaffold, and I've included a basic skaffold.yaml
in the project. Doing a "dev" deployment of Skaffold (where Skaffold watches for
changes and redeploys as necessary) looks like this:

~~~
$ skaffold dev
~~~

Unfortunately, this may not work on Mac M1 hardware. See below for a discussion of
why and what might fix it.

If you can't or don't want to use Skaffold, you can manually deploy it. First, you
will either need to push it into DockerHub (or some image registry) or load it directly
into Kind. To push it to DockerHub:

~~~
$ docker push habuma/hello-k8s:0.0.1-SNAPSHOT
~~~

To load it directly into Kind (without pushing it to any image registry):

~~~
$ kind load docker-image habuma/hello-k8s:0.0.1-SNAPSHOT
~~~

Once the image is in the image registry or in Kind, you can start applying the
YAML manifests. Because the deployment manifest tries to mount a ConfigMap,
you will need to push that first:

~~~
$ kubectl apply -f k8s/HelloConfigMap.yaml
~~~

Then you can apply the deployment/service manifest:

~~~
$ kubectl apply -f k8s/deploy.yaml
~~~

Once `kubectl get all` tells you that the pod(s) are running, you can port-forward
to either a pod or the service. The service is the easiest, because if the pods
change you will only need to CTRL-C out of the port forward session and use history
to create a new port-forward against the same service (no need to copy the new
pod ID). A service port-forward looks like this:

~~~
$ kubectl port-forward service/hello-svc 8080:31234
~~~

Assuming it all went well, you can now issue requests to the deployed app:

~~~
$ curl localhost:8080/hello
Hello from Kubernetes!
~~~

## A few more tricks

You can tail the logs on all of the pods using Stern:

~~~
$ stern hello-k8s
~~~

Or you can SSH into a pod. Copy the pod's ID (from `kubectl get all`) and replace
the pod ID in the following command line:

~~~
$ kubectl exec --stdin --tty pod/hello-k8s-6854bd868f-4bjbg -- /bin/bash
~~~

From there you can `cd` into the `/etc/config` to view the `greeting.message`
file which was put there as a result of mounting the ConfigMap.


## What went wrong?

For those who were there and witnessed the
disaster that occurred during the last half-hour, here's a breakdown of what
happened:

 - As I mentioned repeatedly, I am unable to run Skaffold successfully on my
   Mac M1. (More on that below.)
 - Because I can't run Skaffold, I was manually deploying changes to the cluster.
 - What I failed to do, however, is rebuild and push those changes to Docker Hub.
   This is something I wouldn't need to do if I were able to use Skaffold, because
   Skaffold automatically pushes images it builds directly into the cluster
   (bypassing an image registry altogether). I didn't notice this because under
   normal circumstances, I am able to run Skaffold because most of my K8s work
   takes place on my Intel machine, not my ARM64 machine.
 - Once I figured that out, some things were slightly better, but some were not.
 - Ultimately, the basic issue that plagued me with port forwarding and pods
   randomly and in increasingly frequency failing to start was due to Docker
   running out of memory.
 - I restarted Docker and everything started working fine. The final 20 minutes
   of the workshop recording (after the workshop time had ended) show my success.
 - Following the workshop conclusion, I tweaked some settings on Docker to avoid
   this in the future.
 - Ugh.

## Skaffold and Mac M1

What follows is my understanding of the issue of running Skaffold on Mac M1.

Skaffold has no problem running on a Mac M1 machine. But, its default behavior
is to not trust any custom builders you give it. It will try to inject its own.
And, that seems to mean that it picks a builder targeting Intel chips. As a result,
Skaffold fails because M1 is an ARM64-based architecture.

The way around that is to set `trustBuilder` to `true` in the skaffold.yaml file
like this:

~~~
apiVersion: skaffold/v2beta25
kind: Config
metadata:
  name: hello-k-s
build:
  artifacts:
  - image: habuma/hello-k8s
    buildpacks:
      builder: gcr.io/buildpacks/builder:v1
      trustBuilder: true
deploy:
  kubectl:
    manifests:
    - k8s/deploy.yaml
~~~

I've heard from people who say that one line is the magic that makes is work. But,
for me at least, it only helps it get further before failure. With `trustBuilder`
set, I've seen it fail with a segmentation fault on many occasions and I've seen
it just get stuck for over a half hour (before I CTRL-C out of it) on other occasions.

Just sharing this in case it helps anyone. Also, if you have success with Skaffold
on Mac M1 hardward, please let me know and help me figure it out. Had this essential
thing worked, much of the hassle toward the end of the workshop wouldn't have been
as bad. (Docker would've still be trouble, but at least I wouldn't have had to
manually rebuild and push to Docker hub each time I made a change.)
