public class BankSolid {
    public static void main(String[] args) {
        Tabungan ani = new Tabungan("101", "Ani", 1000000, 2.5);
        Tabungan citra = new Tabungan("102", "Citra", 300000, 2.0);
        Giro budi = new Giro("201", "Budi", 200000, 500000);
        Deposito dewi = new Deposito("301", "Dewi", 5000000, 4.0);

        Rekening[] semua = { ani, citra, budi, dewi };

        BisaDitarik[] bisaDitarik = {ani, citra, budi};
        //java: incompatible types: Deposito cannot be converted to BisaDitarik
        // BisaDitarik[] salah = {ani, dewi};

        BerBunga[] berbunga = { ani, citra, dewi };

        Notifikasi notifikasi = new EmailNotifikasi();

        //Notifikasi notifikasi = new SmsNotifikasi();
        /*========== REKENING AWAL ==========
        101 | Ani    |  Rp1.000.000
        Tabungan, bunga 2.5% per bulan
        102 | Citra  |    Rp300.000
        Tabungan, bunga 2.0% per bulan
        201 | Budi   |    Rp200.000
        Giro, batas overdraft Rp500.000
        301 | Dewi   |  Rp5.000.000
        Deposito, bunga 4.0% per bulan

                ========== AKHIR BULAN ============
                [SMS     101] biaya admin Rp0
                [SMS     102] biaya admin Rp5.000
                [SMS     201] biaya admin Rp15.000
                [SMS     301] biaya admin Rp0
                [SMS     101] bunga Rp25.000
                [SMS     102] bunga Rp5.900
                [SMS     301] bunga Rp200.000
                [SMS     101] autodebet Rp50.000
                [SMS     102] autodebet Rp50.000
                [SMS     201] autodebet Rp50.000

                ========== REKENING AKHIR =========
                101 | Ani    |    Rp975.000
        Tabungan, bunga 2.5% per bulan
        102 | Citra  |    Rp250.900
        Tabungan, bunga 2.0% per bulan
        201 | Budi   |    Rp135.000
        Giro, batas overdraft Rp500.000
        301 | Dewi   |  Rp5.200.000
        Deposito, bunga 4.0% per bulan
                -----------------------------------
                Total dana bank : Rp6.560.900

        Process finished with exit code 0*/
        // Untuk mengganti jenis notifikasi menjadi SMS,
        // cukup ubah EmailNotifikasi() menjadi SmsNotifikasi().

        ProsesAkhirBulan proses = new ProsesAkhirBulan(notifikasi);

        LaporanBank laporan = new LaporanBank();

        laporan.cetakDaftar("========== REKENING AWAL ==========", semua);
        System.out.println();
        System.out.println("========== AKHIR BULAN ============");
        proses.potongBiayaAdmin(semua);
        proses.tambahBunga(berbunga);
        proses.autodebet(bisaDitarik, 50000);
        System.out.println();
        laporan.cetakDaftar("========== REKENING AKHIR =========", semua);
        laporan.cetakTotal(semua);
    }
}