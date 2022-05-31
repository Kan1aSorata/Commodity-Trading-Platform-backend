package com.bistu.secondhandtradeplatform.util;

import com.bistu.secondhandtradeplatform.entity.Commodity;

import java.util.Comparator;

public class CommodityComparator implements Comparator<Commodity> {

    public int compareByPriceLH(Commodity o1, Commodity o2) {
        if (o1.getPrice() - o2.getPrice() > 0) {
            return 1;
        } else if (o1.getPrice() - o2.getPrice() < 0) {
            return -1;
        } else return 0;
    }

    public int compareByPriceHL(Commodity o1, Commodity o2) {
        if (o1.getPrice() - o2.getPrice() > 0) {
            return -1;
        } else if (o1.getPrice() - o2.getPrice() < 0) {
            return 1;
        } else return 0;
    }

    public int compareBySalesLH(Commodity o1, Commodity o2) {
        return Integer.compare(o1.getSales() - o2.getSales(), 0);
    }

    public int compareBySalesHL(Commodity o1, Commodity o2) {
        return Integer.compare(0, o1.getSales() - o2.getSales());
    }

    public int compareByScoreLH(Commodity o1, Commodity o2) {
        if (o1.getScore() - o2.getScore() > 0) {
            return 1;
        } else if (o1.getScore() - o2.getScore() < 0) {
            return -1;
        } else return 0;
    }

    public int compareByScoreHL(Commodity o1, Commodity o2) {
        if (o1.getScore() - o2.getScore() > 0) {
            return -1;
        } else if (o1.getScore() - o2.getScore() < 0) {
            return 1;
        } else return 0;
    }

    @Override
    public int compare(Commodity o1, Commodity o2) {
        return 0;
    }
}
