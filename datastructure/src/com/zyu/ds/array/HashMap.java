package com.zyu.ds.array;

public class HashMap<K, V> {

    /**
     * // 判断哈希表中是否存在键 key
     * boolean	containsKey(Object key)
     * <p>
     * // 获得键 key 对应的值，若 key 不存在，则返回 null
     * V get(Object key)
     * <p>
     * // 将 key, value 键值对存入哈希表
     * V put(K key, V value)
     * <p>
     * // 如果 key 存在，删除 key 并返回对应的值
     * V remove(Object key)
     */


    private static final int DEFAULT_CAPACITY = 16;

    private static final float DEFAULT_LOAD_FACTORY = 0.75f;

    private int size;

    private float loadFactor;

    private Node<K, V>[] buckets;


    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public HashMap(int initialCapacity, float loadFactor) {
        this.size = 0;
        this.loadFactor = loadFactor;
        this.buckets = new Node[initialCapacity];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        Node<K, V> entry = buckets[bucketIndex];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        Node<K, V> headEntry = buckets[bucketIndex];
        while (headEntry != null) {
            if (headEntry.key.equals(key)) {
                headEntry.value = value;
                return;
            }
            headEntry = headEntry.next;
        }

        //key not found,add new entry to the beginning of the bucket list
        Node<K, V> newEntry = new Node<>(key, value, headEntry);
        size++;
        buckets[bucketIndex] = newEntry;

        if (size / buckets.length > loadFactor) {
            resize();
        }
    }

    public void remove(K key) {
        int bucketIndex = getBucketIndex(key);
        Node<K, V> preEntry = null;
        Node<K, V> currnetEntry = buckets[bucketIndex];
        while (currnetEntry != null) {
            if (currnetEntry.key.equals(key)) {
                if (preEntry == null) {
                    buckets[bucketIndex] = currnetEntry.next;
                } else {
                    preEntry.next = currnetEntry.next;
                }
                size--;
                return;
            }
            preEntry = currnetEntry;
            currnetEntry = currnetEntry.next;

        }
    }

    public boolean containsKey(K key) {
        int bucketIndex = getBucketIndex(key);
        Node<K, V> headEntry = buckets[bucketIndex];
        while (headEntry != null) {
            if (headEntry.key.equals(key)) {
                return true;
            }
            headEntry = headEntry.next;
        }
        return false;
    }

    /**
     * easy way to implement containsKey()
     *
     * @param key
     * @param mark not use
     * @return
     */
    public boolean containsKey(K key, String mark) {
        return get(key) != null;
    }

    private void resize() {
        Node<K, V>[] oldBuckets = buckets;
        buckets = new Node[oldBuckets.length * 2];
        size = 0;
        for (Node<K, V> entry : buckets) {
            while (entry != null) {
                put(entry.key, entry.value);
                entry = entry.next;
            }
        }
    }

    private int getBucketIndex(K key) {
        return key == null ? 0 : Math.abs(key.hashCode() % buckets.length);
    }
}