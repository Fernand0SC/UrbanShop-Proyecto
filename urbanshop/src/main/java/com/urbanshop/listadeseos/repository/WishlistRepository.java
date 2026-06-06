package com.urbanshop.listadeseos.repository;
import com.urbanshop.listadeseos.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long>{
    List<Wishlist> findByUsuarioId(Long usuarioId);

    boolean existsByUsuarioIdAndProductoId(Long usuarioId, Long productoId);
}
