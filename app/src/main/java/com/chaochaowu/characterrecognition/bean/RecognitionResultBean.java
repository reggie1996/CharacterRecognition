package com.chaochaowu.characterrecognition.bean;

import java.util.List;

/**
 * @author chaochaowu
 * @Description :
 * @classes :
 * @time Create at 6/4/2018 4:48 PM
 */


public class RecognitionResultBean {

    @Override
    public String toString() {
        return "RecognitionResultBean{" +
                "log_id=" + log_id +
                ", words_result_num=" + words_result_num +
                ", words_result=" + words_result +
                '}';
    }

    /**
     * log_id : 2471272194
     * words_result_num : 2
     * words_result : [{"words":" TSINGTAO"},{"words":"青島睥酒"}]
     */


    private long log_id;
    private int words_result_num;
    private List<WordsResultBean> words_result;

    public long getLog_id() {
        return log_id;
    }

    public void setLog_id(long log_id) {
        this.log_id = log_id;
    }

    public int getWords_result_num() {
        return words_result_num;
    }

    public void setWords_result_num(int words_result_num) {
        this.words_result_num = words_result_num;
    }

    public List<WordsResultBean> getWords_result() {
        return words_result;
    }

    public void setWords_result(List<WordsResultBean> words_result) {
        this.words_result = words_result;
    }

    public static class WordsResultBean {
        @Override
        public String toString() {
            return "WordsResultBean{" +
                    "words='" + words + '\'' +
                    '}';
        }

        /**
         * words :  TSINGTAO
         */



        private String words;

        public String getWords() {
            return words;
        }

        public void setWords(String words) {
            this.words = words;
        }
    }
}
