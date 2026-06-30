package com.example.fragmentsinger.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.fragmentsinger.model.Singer;

public class SingerViewModel extends ViewModel {

    private final MutableLiveData<Singer> selectedSinger = new MutableLiveData<>();

    public void selectSinger(Singer singer) {
        selectedSinger.setValue(singer);
    }

    public MutableLiveData<Singer> getSelectedSinger() {
        return selectedSinger;
    }
}
