class MyCalendar {
    List<Interval> bookings;
    public MyCalendar() {
        bookings = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for (Interval it: bookings) {
            if ((start < it.end && start >= it.start)|| (end > it.start && end <= it.end) || (start <= it.start && end >= it.end)) {
                return false;
            }
        }
        bookings.add(new Interval(start, end));
        return true;
    }
    class Interval {
        int start;
        int end;
        Interval(int s, int e) {
            start = s;
            end = e;
        };
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
