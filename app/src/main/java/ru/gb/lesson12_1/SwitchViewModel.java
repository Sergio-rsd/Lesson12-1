package ru.gb.lesson12_1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SwitchViewModel extends ViewModel {

    // данные для второго фрагмента
    private MutableLiveData<String> firstData = new MutableLiveData<>();

    // MutableLiveData - можно изменить
    // данные для первого фрагмента
    private MutableLiveData<String> secondData = new MutableLiveData<>();

    // LiveData - можно только подписаться на изменение
    // на это подписывается первый фрагмент
    public LiveData<String> getFirst()
    {
        return secondData;
    }

    // на это подписывается второй фрагмент
    public LiveData<String> getSecond()
    {
        return firstData;
    }

    // вызывается первым фрагментом
    public void firstSay(String string)
    {
        // firstData.setValue(string); // в основном потоке приложения
        firstData.postValue(string); // можно делать из любого потока
    }


    // вызывается вторым фрагментом
    public void secondSay(String string)
    {
        secondData.postValue(string);
    }


}
