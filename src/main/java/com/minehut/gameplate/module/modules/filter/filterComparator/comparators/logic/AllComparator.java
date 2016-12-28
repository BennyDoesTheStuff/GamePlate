package com.minehut.gameplate.module.modules.filter.filterComparator.comparators.logic;

import com.minehut.gameplate.module.modules.filter.filterComparator.FilterComparator;
import com.minehut.gameplate.module.modules.filter.filterComparator.FilterResponse;

import java.util.List;

/**
 * Created by luke on 12/27/16.
 */
public class AllComparator extends FilterComparator {
    private List<FilterComparator> children;

    public AllComparator(List<FilterComparator> children) {
        this.children = children;
    }

    @Override
    public FilterResponse evaluate(Object... objects) {

        boolean abstain = true;

        for (FilterComparator comparator : children) {
            FilterResponse response = comparator.evaluate(objects);

            if (response == FilterResponse.DENY) {
                return FilterResponse.DENY;
            } else if (response != FilterResponse.ABSTAIN) {
                abstain = false;
            }
        }
        if (abstain) {
            return FilterResponse.ABSTAIN;
        } else {
            return FilterResponse.ALLOW;
        }
    }
}
