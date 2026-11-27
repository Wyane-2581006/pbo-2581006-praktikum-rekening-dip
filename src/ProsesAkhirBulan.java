public class ProsesAkhirBulan {
    public void potongBiayaAdmin(Rekening[] semua) {
        for (Rekening r : semua) {
            int biaya = r.potongBiayaAdmin();
            System.out.printf("%s biaya admin  : %s%n", r.getNomor(), Rekening.formatRupiah(biaya));
        }
    }

    public void tambahBunga(BerBunga[] berbunga) {
        for (BerBunga b : berbunga) {
            int bunga = b.tambahBunga();
            System.out.printf("%s bunga        : %s%n", b.getNomor(), Rekening.formatRupiah(bunga));
        }
    }

    public void autodebet(BisaDitarik[] bisaDitarik, int jumlah) {
        for (BisaDitarik b : bisaDitarik) {
            String hasil = b.tarik(jumlah)
                    ? Rekening.formatRupiah(jumlah)
                    : "Gagal";

            System.out.printf("%s autodebet : %s%n", b.getNomor(),hasil);
        }
    }

}