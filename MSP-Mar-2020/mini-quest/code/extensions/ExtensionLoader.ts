import { DriverExtension, InstructionExtension, ImporterExtension } from '@alexa-games/sfb-f';
import { ExtensionLoaderParameter, AlexaExtension, AlexaAPLExtension, AlexaAudioPlayerExtension, AlexaMonetizationExtension } from '@alexa-games/sfb-skill';

type ExtensionType = DriverExtension|InstructionExtension|ImporterExtension;

export class ExtensionLoader {
    private readonly registeredExtensions: ExtensionType[];

    constructor(param: ExtensionLoaderParameter) {
        this.registeredExtensions = [
            // Alexa SFB extensions
            new AlexaExtension(),
            new AlexaAPLExtension(param.locale, param.configAccessor),
            new AlexaAudioPlayerExtension(param.locale, param.configAccessor),            
            new AlexaMonetizationExtension(param.locale, param.configAccessor)
        ];
    }

    public getExtensions(): ExtensionType[] {
        return this.registeredExtensions;
    }
}
