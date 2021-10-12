class FunctionTest {
  Stream<String> cities = Stream.of("Tokio", "New York", "Miskolc", "Marokko", "Mo");
  
  @Test
  public void ConsumerTest(){
      Consumer<String> printConsumer = t -> System.out.println(t);
      cities.forEach(printConsumer);
  }
  
  @Test
  public void supplierTest(){
      Supplier<Double> doubleSupplier = () -> Math.random();
      System.out.println(doubleSupplier.get());
  }
  
  @Test
  public void predicateTest(){
      Predicate<String> startPredicate = str -> str.startsWith("M");
      Predicate<String> lengthPredicate = str -> str.length() >= 3;
      cities.filter(startPredicate.and(lengthPredicate)).forEach(System.out::println);
  }
  
  @Test
  public void testFunction(){
      Function<String, Integer> nameMappingFunction = String::length;
      List<Integer> nameLengthList = cities.map(nameMappingFunction).collect(Collectors.toList());
      System.out.println(nameLength);
  }
}
