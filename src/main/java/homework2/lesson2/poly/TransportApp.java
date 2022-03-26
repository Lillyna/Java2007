package homework2.lesson2.poly;

public class TransportApp {
    public static void main(String[] args) {
        Transport[] transports = new Transport[]{new Yacht(), new Bus(), new Ship()};//is a: bus is a transport, ship is a transport, yacht is a transport
        for(Transport transport: transports){
            transport.load();
            if (transport instanceof Swimmable){
                System.out.println("Эта штука плавает");
                Swimmable swimmable = (Swimmable)transport; //приведение типа, type-cast
                swimmable.swim();
            }
            if (transport instanceof Bus){
                Bus bus = (Bus) transport;
                System.out.println("Маршрут " + bus.getRoute());
            }
        }

        NewsService newsService = new OrcaleNewsService();
        //complex logic
        newsService.getNews();
    }
}
