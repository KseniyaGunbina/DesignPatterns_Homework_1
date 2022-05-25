import java.nio.charset.StandardCharsets;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age;
    protected boolean ageInst;
    protected String address;
    protected boolean addressInst;

    public boolean exceptionForString(String str) {
        boolean result = false;
        char[] chars = str.toCharArray();
        for (char character : chars) {
            if (Character.isDigit(character)) {
                throw new IllegalStateException("Некорректный формат данных поля.");
            }
        }
        return result;
    }

    public PersonBuilder setName(String name) {
        if (!exceptionForString(name))
            this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (!exceptionForString(surname))
            this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 || age > 100) // считаем, что максимальная продолжительность жизни 100 лет
            throw new IllegalStateException("Некорректно введен возраст");
        this.age = age;
        this.ageInst = true;

        return this;
    }

    public PersonBuilder setAddress(String address) {
        if (!exceptionForString(address)) {
            this.address = address;
            this.addressInst = true;
        }
        return this;
    }

    public Person build(){
        Person person;
        if (name == null || surname == null)
            throw new IllegalStateException("Не заполнены обязательные поля.");

        if (ageInst) {
            person = new Person(name, surname, age);
        } else
            person = new Person(name, surname);

        if (addressInst)
            person.setAddress(address);

        return person;
    }
}

