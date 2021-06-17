package resliv.by.cities_guide_information.configuration;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import resliv.by.cities_guide_information.services.impl.TelegramBotService;

import javax.annotation.PostConstruct;

import static lombok.AccessLevel.PRIVATE;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class TelegramBotConfiguration {

    @Autowired
    TelegramBotService telegramBotService;

    @PostConstruct
    public void init() {

        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(telegramBotService);
        } catch (TelegramApiException telegramApiException) {
            telegramApiException.printStackTrace();
        }
    }

}
