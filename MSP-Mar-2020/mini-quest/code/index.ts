import { SkillBuilders, HandlerInput, DynamoDbPersistenceAdapter } from 'ask-sdk';
import { ConfigAccessor, SFBRequestHandlerFactory, UserAgentHelper } from '@alexa-games/sfb-skill';
import * as path from 'path';

import { ExtensionLoader } from './extensions/ExtensionLoader';

const projectRootPath = __dirname;
const configAccessor = new ConfigAccessor(require(path.resolve("abcConfig", "abcConfig.json")), path.resolve(projectRootPath, 'res'));

/**
 * Skill handler (Request Entry Point)
 */
export async function handler(event: any, context: any, callback: any) {
	console.log(`[INFO] Request Received: ${JSON.stringify(event, null, 4)}`);

	const customExtensionLoader = new ExtensionLoader({
		locale: event.request.locale,
		configAccessor
	});

	const sfbHandler = SFBRequestHandlerFactory.create(event, context, customExtensionLoader.getExtensions(), configAccessor, projectRootPath);
	
	// Assign what requests should be handled by SFB
	sfbHandler.canHandle = function(handlerInput : HandlerInput): boolean {
		return true; // handle every request for now.
	}

	const skill = SkillBuilders.custom()
		.addRequestHandlers(
			sfbHandler
		)
		.withPersistenceAdapter(
			new DynamoDbPersistenceAdapter({
				tableName : sfbHandler.getTableName(),
				createTable: true
			})
		)
		.withCustomUserAgent(UserAgentHelper.createCustomUserAgent())
		.create();
	
	const response = await skill.invoke(event, context);

	console.log(`[INFO] Outgoing Response: ${JSON.stringify(response, null, 4)}`);
	return response;
}