package Playlist;

    class Song {
        String name;
        String artist;
        Song next;

        public Song(String name, String artist) {
            this.name = name;
            this.artist = artist;
            this.next = null;
        }
    }
    class Playlist {
        Song head;

        public Playlist() {
            this.head = null;
        }

        public void addSong(String name, String artist) {
            Song newSong = new Song(name, artist);
            newSong.next = head;
            head = newSong;
            System.out.println("Đã thêm: " + name + " bởi " + artist);
        }

public void deleteSongName(String songName) {

    if (head == null) {
        System.out.println("list trống");
        return;
    }
    // xoá bài đầu tiên
    if (head.name.equals(songName)) {
        head = head.next;
        System.out.println("xóa playlist " + songName);
        return;
    }
    Song current = head;
    while (current.next != null && !current.next.name.equals(songName)) {
        current = current.next;
    }
    if (current.next == null) {
        System.out.println("Không tồn tại:");
    }
    else if (current.next.next == null) {
        System.out.println("Đã xóa bài cuối cùng: " + songName);
        current.next = null;
    }
    else {
        current.next = current.next.next;
    }
}

        // Traverse the playlist and print out all songs
        public void printPlaylist() {
            Song current = head;
            if (current == null) {
                System.out.println("The playlist is empty.");
                return;
            }

            System.out.println("Playlist:");
            while (current != null) {
                System.out.println(current.name + " by " + current.artist);
                current = current.next;
            }
        }
        public static void main(String[] args) {
            Playlist myPlaylist = new Playlist();

            myPlaylist.addSong("Chúng ta của hiện tại", "Sơn Tùng MTP");
            myPlaylist.addSong("Đừng yêu nữa anh mệt rồi", "Hoàng Dũng");
            myPlaylist.addSong("Mặt trời của em", "Phương Ly");
            myPlaylist.addSong("Cua","Hieuthuhai");
            myPlaylist.addSong("Nàng thơ","Dũng");

            myPlaylist.printPlaylist();

            myPlaylist.deleteSongName("Chúng ta của hiện tại");
            myPlaylist.printPlaylist();
        }
    }


