/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                delete(storage[i].uuid);
            }
        }
    }

    void save(Resume r) {
        int index = 0;

        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                index = i;
                break;
            }
        }

        if (r != null) {
            storage[index] = r;
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < storage.length; i++) {
//            System.out.println(storage[i].uuid);
            if (storage[i] != null && storage[i].uuid == uuid) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && storage[i].uuid == uuid) {
                storage[i] = null;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] newResume = new Resume[size()];
        int index = 0;
        for (Resume resume : storage) {
            if (resume != null) {
                //System.out.println(resume);
                newResume[index++] = resume;
            }
        }
        return newResume;
    }

    int size() {
        int counter = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                counter++;
            }
        }
        return counter;
    }
}
