package Dao;

import Entity.Word;

public interface WordDao {
    boolean insert(Word word);
    Word search(String userHash);
    Word select();
}
