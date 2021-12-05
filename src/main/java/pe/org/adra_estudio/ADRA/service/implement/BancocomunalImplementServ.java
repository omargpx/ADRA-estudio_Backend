package pe.org.adra_estudio.ADRA.service.implement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import pe.org.adra_estudio.ADRA.entity.BancoComunal;
import pe.org.adra_estudio.ADRA.repository.BancoComunalRepo;
import pe.org.adra_estudio.ADRA.service.BancoComunalService;

@Service
public class BancocomunalImplementServ implements BancoComunalService {

    @Autowired
    private BancoComunalRepo BancoComunalRepo;

    @Override
    public BancoComunal save(BancoComunal banco) {
        return BancoComunalRepo.save(banco);
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(BancoComunal banco) {
        BancoComunalRepo.delete(banco);
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<BancoComunal> findAll() {
        return (List<BancoComunal>) BancoComunalRepo.findAll();
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public BancoComunal findById(int id) {
        return BancoComunalRepo.findById(id).orElse(null);
    
    }

    @Override
    public List<BancoComunal> findAll(String query, String sortBy) {
        Sort sort;
        if (!sortBy.equals("")) {
            String sortColumn = sortBy.split("\\|")[0];
            String sortDirection = sortBy.split("\\|")[1].toUpperCase();
            sort = Sort.by(sortDirection.equals("DESC") ? Sort.Direction.DESC : Sort.Direction.ASC, sortColumn);
        } else {
            sort = Sort.by(Sort.Direction.ASC, "id_banco_comunal");
        }
        return BancoComunalRepo.findAll("%" + query.toUpperCase() + "%", sort);
    }

    @Override
    public HashMap<String, Object> findAll(String query, int page, int limit, String sortBy) {
        HashMap<String, Object> result = new HashMap<>();
        Pageable pageable;
        if (!sortBy.equals("")) {
            String sortColumn = sortBy.split("\\|")[0];
            String sortDirection = sortBy.split("\\|")[1].toUpperCase();

            Sort sort = Sort.by(sortDirection.equals("DESC") ? Sort.Direction.DESC : Sort.Direction.ASC, sortColumn);
            pageable = PageRequest.of(page - 1, limit, sort);
        } else {
            Sort sort = Sort.by(Sort.Direction.ASC, "id_banco_comunal");
            pageable = PageRequest.of(page - 1, limit, sort);
        }

        Page<BancoComunal> data = BancoComunalRepo.findAllParams("%" + query.toUpperCase() + "%", pageable);

        if (!data.getContent().isEmpty()) {
            result.put("items", data.getContent());
        } else {
            result.put("items", new ArrayList<BancoComunal>());
        }
        result.put("totalPage", data.getTotalPages());
        result.put("totalRows", data.getNumberOfElements());
        result.put("page", page);
        result.put("limit", limit);
        return result;
    }

}
