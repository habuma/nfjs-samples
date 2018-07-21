package nametaker;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(Source.class)
public class NameGatheringController {

	@Autowired
	private Source source;
	
	@RequestMapping(path="/", method=RequestMethod.POST, consumes="text/plain")
	public String postName(@RequestBody String name) {
		source.output().send(MessageBuilder.createMessage(name, 
				new MessageHeaders(Collections.singletonMap(MessageHeaders.CONTENT_TYPE, "text/plain"))));
		return name; 
	}

}
