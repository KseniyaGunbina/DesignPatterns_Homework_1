public class Person {
    protected final String name;
    protected  final  String surname;
    protected int age;
    protected boolean ageInst = false;
    protected String address;
    protected boolean addressInst = false;

    // конструктор без возраста
    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    // конструктор с известным возрастом
    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        ageInst = true;
    }

    // TODO прописать метод увеличения возраста
    public boolean happyBirthday() {
        if (!ageInst)
            throw new IllegalStateException("Возраст пользователя не указан.");
        this.age++;
        return true;
    }
    public void setAddress(String address) {
        this.address = address;
        addressInst = true;
    }

    // геттеры
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public int getAge() {
        return age;
    }
    public String getAddress() {
        return address;
    }

    // известен ли возраст?
    public boolean hasAge(){
        return ageInst;
    }

    // известен ли город?
    public boolean hasAddress(){
        return addressInst;
    }

    // билдер для ребенка
    public PersonBuilder newChildBuilder(){
        PersonBuilder childPersonBuilder = new PersonBuilder();
        childPersonBuilder.setSurname(this.surname);
        childPersonBuilder.setAge(0);
        childPersonBuilder.ageInst = true;
        if (addressInst) {
            childPersonBuilder.setAddress(this.address);
            childPersonBuilder.addressInst = true;
        }
        return childPersonBuilder;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
