class LRUCache {
    int cap;
    // key is the key, value is the iterator of list
    unordered_map <int, list<pair<int, int>>::iterator> my_map;
    // it->first = key, it->second = value of data.
    list<pair<int, int>> my_list;
public:
    explicit LRUCache(int capacity): cap(capacity){
    }
    // Get the value (will always be positive) of the key if the key exists in the cache, 
    // otherwise return -1.
    int get(int key) {
        auto found_it = my_map.find(key);
        if (found_it != my_map.end()) {
            // key exists, get value
            auto it = found_it->second;
            my_list.splice(my_list.begin(), my_list, it);
            return my_list.begin()->second;
        } 
        return -1;
    }
    
    // Set or insert the value if the key is not already present
    // When the cache reached its capacity, 
    // it should invalidate the least recently used item before inserting a new item
    void put(int key, int value) {
        auto found_it = my_map.find(key);
        if (found_it != my_map.end()) {
            // exist
            auto it = found_it->second;
            my_list.splice(my_list.begin(), my_list, it);
            it->second = value;
        } else {
            // does not exist
            my_list.emplace_front(key, value);
            my_map[key] = my_list.begin();
            if (my_map.size() > cap) {
                int to_be_delete = my_list.back().first;
                my_list.pop_back();
                my_map.erase(to_be_delete);
            }
        }
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */
