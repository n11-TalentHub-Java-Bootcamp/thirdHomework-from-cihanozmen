package com.cihanozmen.springboot;

import com.cihanozmen.springboot.entity.Kategori;
import com.cihanozmen.springboot.entity.Urun;
import com.cihanozmen.springboot.entityService.KategoriEntityService;
import com.cihanozmen.springboot.entityService.UrunEntityService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringBootTrainingApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext =
				SpringApplication.run(SpringBootTrainingApplication.class, args);

		KategoriEntityService kategoriEntityService = applicationContext.getBean(KategoriEntityService.class);
		UrunEntityService urunEntityService = applicationContext.getBean(UrunEntityService.class);

		//Kategori kategori = getTelefonKategori(service);
		//saveKitap(kategoriEntityService);


//		List<Kategori> kategoriList = kategoriEntityService.findAllByUstKategoriIsNull();
//
//		for (Kategori kategori: kategoriList){
//			System.out.println(kategori.getAdi());
//		}
	}
	private  static void saveKitap(KategoriEntityService kategoriEntityService){
		Kategori kitap = new Kategori();
		kitap.setAdi("Kitap");
		kitap.setKirilim(1L);

		kitap = kategoriEntityService.save(kitap);

		Kategori kitapAlt = new Kategori();
		kitapAlt.setKirilim(2L);
		kitapAlt.setAdi("Kitap");
		kitapAlt.setUstKategori(kitap);

		kategoriEntityService.save(kitapAlt);
	}

	private static void findAllUrunList(UrunEntityService urunEntityService){
		List<Urun> urunList = urunEntityService.findAll();

		for(Urun urun : urunList){
			System.out.println(urun);
		}
	}

	private static void deleteUrunList(UrunEntityService urunEntityService){
		//List<Long> silinecekUrunIdList = Arrays.asList("buraya silincecek ıdler yazılır");
		//for(Long urunId: silinecekUrunIdList){
		//	urunEntityService.deleteById(urunId);
	//	}
	}

	private static void getSamsungM31(KategoriEntityService kategoriEntityService, UrunEntityService urunEntityService){
		Kategori kategori = kategoriEntityService.findById(502L);
		Urun urun = new Urun();
		urun.setAdi("samsung m31");
		urun.setFiyat(new BigDecimal(3000));
		urun.setKayitTarihi(new Date());
		urun.setKategori(kategori);
		urun = urunEntityService.save(urun);
		System.out.println(urun);
	}

	private static Kategori getTelefonKategori(KategoriEntityService service){
		Kategori ustKategori = service.findById(2L);

		Kategori kategori = new Kategori();

		kategori.setAdi("Telefon");
		kategori.setKirilim(2L);
		kategori.setUstKategori(ustKategori);

		kategori=service.save(kategori);
		return kategori;

	}


}
