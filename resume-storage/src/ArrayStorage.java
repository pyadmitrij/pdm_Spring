import java.util.LinkedList;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++)
            storage[i] = null;
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        Resume result = null;
        for (int i = 0; i < size(); i++)
            if (storage[i].uuid.equals(uuid))
                result = storage[i];
        return result;
    }

    void delete(String uuid) {
        for (int i = 0; i < size(); i++) {
            Resume temp = null;
            if (storage[i].uuid.equals(uuid)) {
                temp = storage[i];
                storage[i] = storage[i + 1];
                storage[i + 1] = temp;
            }
        }

        for (int i = 0; i < size(); i++)
            if (storage[i] == null) {
                size();
            }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] result = new Resume[size()];
        for (int i = 0; i < size(); i++)
            result[i] = storage[i];
        return result;
    }

    int size() {
        int size = 0;
        for (int i = 0; i < storage.length; i++)
            if (storage[i] != null)
                size++;
        return size;
    }
}
