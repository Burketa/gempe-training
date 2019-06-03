package com.example.netflix_clone.model;

import java.util.ArrayList;

public class Currency {
    //private String currency;

    private ArrayList<Info> info;

    public class Info{

        private float buy;
        private float sell;

        public float getBuy() {
            return buy;
        }

        public void setBuy(float buy) {
            this.buy = buy;
        }

        public float getSell() {
            return sell;
        }

        public void setSell(float sell) {
            this.sell = sell;
        }
    }
}
