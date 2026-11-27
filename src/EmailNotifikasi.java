public class EmailNotifikasi implements Notifikasi{

    @Override
    public void kirim(String nomor, String pesan) {
        System.out.printf("[Email %s] %s%n", nomor, pesan);
    }
}