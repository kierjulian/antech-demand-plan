package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.sales.master.converter.NetsuiteBjjTagging;

import java.util.List;

public interface NetsuiteBjjTaggingDAO {

    public NetsuiteBjjTagging createNetsuiteBjjTagging(NetsuiteBjjTagging netsuiteBjjTagging);

    public List<NetsuiteBjjTagging> findAllNetsuiteBjjTagging();

}
