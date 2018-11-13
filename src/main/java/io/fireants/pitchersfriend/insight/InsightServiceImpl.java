package io.fireants.pitchersfriend.insight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsightServiceImpl implements InsightService {
 
    @Autowired
    private InsightRepository insightRepository;
 
    @Override
    public Insight save(Insight insight) {
        return insightRepository.save(insight);
    }
    
    @Override
    public Insight findById(Long id) {
        return insightRepository.findOne(id);
    }
}
