package overriding;

public class Main {

	public static void main(String[] args) {
		/*
		 * OgretmenKrediManager ogretmenKrediManager = new OgretmenKrediManager();
		 * System.out.println("Ogretmen Kredi Tutarı:" +
		 * ogretmenKrediManager.hesapla(1000));
		 */
		BaseKrediManager[] baseKrediManagers = new BaseKrediManager[] { new TarımKrediManager(),
				new OgretmenKrediManager(), new OgrenciKrediManager()};
		for (BaseKrediManager baseKrediManager : baseKrediManagers) {
			System.out.println(baseKrediManager.hesapla(1000));
		}
	}
}
