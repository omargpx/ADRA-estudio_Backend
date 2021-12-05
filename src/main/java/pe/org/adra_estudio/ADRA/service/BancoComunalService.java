package pe.org.adra_estudio.ADRA.service;

import java.util.HashMap;
import java.util.List;

import pe.org.adra_estudio.ADRA.entity.BancoComunal;

public interface BancoComunalService {

    public List<BancoComunal> findAll();

    public BancoComunal findById(int id);

    public BancoComunal save(BancoComunal banco);

    public void delete(BancoComunal banco);

    public List<BancoComunal> findAll(String query, String sortBy);

    public HashMap<String, Object> findAll(String query, int page, int limit, String sortBy);

}
