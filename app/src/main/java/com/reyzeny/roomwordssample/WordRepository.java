package com.reyzeny.roomwordssample;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class WordRepository {
    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }

    LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insert(Word word) {
        new insertAsyncTask(mWordDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDao mAsyncTaskWordDao;

        insertAsyncTask(WordDao wordDao) {
            this.mAsyncTaskWordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            mAsyncTaskWordDao.insert(words[0]);
            return null;
        }
    }
}
