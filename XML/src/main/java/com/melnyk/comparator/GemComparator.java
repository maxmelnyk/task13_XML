package com.melnyk.comparator;

import com.melnyk.model.Gem;
import java.util.Comparator;

public class GemComparator implements Comparator<Gem> {
    @Override
    public int compare(Gem o1, Gem o2) {
        return Double.compare(o1.getVisualParameters().getTransparency(), o2.getVisualParameters().getTransparency());
    }
}
