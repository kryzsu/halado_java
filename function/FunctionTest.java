class FunctionTest {
  @Test
  public void ConsumerTest(){
      Consumer<String> printConsumer = t -> System.out.println(t);
      Stream<String> cities = Stream.of("Tokio", "New York", "Miskolc");
      cities.forEach(printConsumer);
  }
  
  @Test
  public void supplierTest(){
      Supplier<Double> doubleSupplier = () -> Math.random();

      System.out.println(doubleSupplier.get());
  }
  
  @Test
  public void predicateTest(){
      List<String> names = Arrays.asList("John", "Johan", "Blue", "Joe", "Siri");
      Predicate<String> startPredicate = str -> str.startsWith("J");
      Predicate<String> lengthPredicate = str -> str.length() >= 3;
      names.stream().filter(startPredicate.and(lengthPredicate)).forEach(System.out::println);
  }
}
