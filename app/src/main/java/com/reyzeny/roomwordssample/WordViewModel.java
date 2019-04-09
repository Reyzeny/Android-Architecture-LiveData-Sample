package com.reyzeny.roomwordssample;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class WordViewModel extends AndroidViewModel {
    private WordRepository mRepoistory;
    private LiveData<List<Word>> mAllWords;
    public WordViewModel(@NonNull Application application) {
        super(application);
        mRepoistory = new WordRepository(application);
        mAllWords = mRepoistory.getAllWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }
    public void insert(Word word) {
        mRepoistory.insert(word);
    }
}
