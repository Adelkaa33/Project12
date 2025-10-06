public class HandMadeArrayList<T> {

    private int size = 0;
    private Object[] elements;

    public HandMadeArrayList() {
        this.elements = new Object[10];
    }

    public void add(T newElement) {
        // Проверяем, достиг ли текущий размер массива вместимости
        if (size == elements.length) {
            grow();
        }

        // Добавляем новый элемент и увеличиваем счетчик размера
        elements[size] = newElement;
        size = size + 1;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Element with index " + index + " does not exist");
        }
        return (T) this.elements[index];
    }

    private void grow() {
        // Новый массив с вместимостью на 50% больше
        Object[] newArray = new Object[elements.length + elements.length / 2];

        // Копируем элементы из старого массива в новый
        for (int i = 0; i < elements.length; i++) {
            newArray[i] = elements[i];
        }

        // Подменяем массив elements на новый
        this.elements = newArray;
    }

    public static void main(String[] args) {
        final var ar = new HandMadeArrayList<Integer>();
        for (int i = 0; i < 2000; i++) {
            ar.add(i);
        }
        System.out.println(ar.size); // Выведет 2000
    }
}
