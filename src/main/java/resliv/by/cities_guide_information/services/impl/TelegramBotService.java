package resliv.by.cities_guide_information.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import resliv.by.cities_guide_information.entities.City;
import resliv.by.cities_guide_information.services.CityService;

import java.util.List;

@Service
public class TelegramBotService extends TelegramLongPollingBot {

    @Value("${telegram.bot.username}")
    String userName;

    @Value("${telegram.bot.token}")
    String token;

    @Autowired
    private CityService cityService;

    @Override
    public String getBotUsername() {

        return userName;
    }

    @Override
    public String getBotToken() {

        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        sendCityDescription(message.getChatId().toString(), message.getText());
    }

    private void sendCityDescription(String chatId, String cityName) {
        List<City> cities = cityService.findByNameContains(cityName);
        if (cities.isEmpty()) {
            sendMessage(chatId, "Данный город отсутствует в базе данных");
        } else {
            for (City city : cities) {
                sendMessage(chatId, String.format("%s: %s", city.getName(), city.getDescription()));
            }
        }
    }

    private void sendMessage(String chatId, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(text);
        sendMessage.setChatId(chatId);
        try {
            execute(sendMessage);
        } catch (TelegramApiException telegramApiException) {
            telegramApiException.printStackTrace();
        }

    }
}
