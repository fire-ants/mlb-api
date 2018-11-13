package io.fireants.pitchersfriend.insight;

public interface InsightService {

    public Insight save(Insight insight) ;
    public Insight findById(Long id);
}