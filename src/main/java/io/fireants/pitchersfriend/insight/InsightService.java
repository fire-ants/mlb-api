package io.fireants.pitchersfriend.insight;

import org.springframework.stereotype.Service;

@Service
public class InsightService {
	
    private final InsightRepository insightRepository;
 
    public InsightService(InsightRepository insightRepository) {
        this.insightRepository = insightRepository;
    }

    public Insight save(Insight insight) {
        return insightRepository.save(insight);
    }
    
    public Insight findById(Long id) {
        return insightRepository.findOne(id);
    }
}