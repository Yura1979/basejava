import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    //Resume[] storage = new Resume[10000];
    Resume[] storage;
    int storageSize;

    public ArrayStorage() {
        this.storage = new Resume[10000];
        this.storageSize = 0;
    }

    void clear() {

        Arrays.fill(storage, null);
        this.storageSize = 0;
    }

    void save(Resume r) {

        if (r != null && storageSize < storage.length){
            storage[storageSize++] = r;
            System.out.println("Saving " + r);
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < storageSize; i++) {

            if (storage[i] != null && storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].uuid.equals(uuid)) {
                System.out.println("we deleting " + storage[i]);
                storage[i] = storage[storageSize-1];
                storage[storageSize-1] = null;
                storageSize--;
            }
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {

        return Arrays.copyOfRange(storage, 0, storageSize);
    }

    int size() {

        return storageSize;
    }
}
