package com.example.fragmentsinger.data;

import com.example.fragmentsinger.model.Singer;
import com.example.fragmentsinger.model.Song;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataRepository {

    public static List<Singer> getSingers() {
        List<Singer> singers = new ArrayList<>();
        singers.add(new Singer("Mỹ Tâm"));
        singers.add(new Singer("Sơn Tùng MTP"));
        singers.add(new Singer("Mỹ Linh"));
        singers.add(new Singer("Noo Phước Thịnh"));
        singers.add(new Singer("Đức Phúc"));
        singers.add(new Singer("Jack"));
        singers.add(new Singer("Đan Trường"));
        singers.add(new Singer("Erik"));
        singers.add(new Singer("Trung Quân"));
        return singers;
    }

    public static List<Song> getSongsForSinger(String singerName) {
        Map<String, List<Song>> songMap = new HashMap<>();

        songMap.put("Mỹ Tâm", Arrays.asList(
                new Song("Đừng Nói Lời Chia Tay"),
                new Song("Nơi Tình Yêu Bắt Đầu"),
                new Song("Trái Tim Không Ngủ Yên"),
                new Song("Đau Vì Yêu"),
                new Song("Ngỡ"),
                new Song("Tâm Hồn Tôi")
        ));

        songMap.put("Sơn Tùng MTP", Arrays.asList(
                new Song("Nắng Ấm Xa Dần"),
                new Song("Âm Thầm Bên Em"),
                new Song("Em Của Ngày Hôm Qua"),
                new Song("Chạy Ngay Đi"),
                new Song("Hãy Trao Cho Anh"),
                new Song("Muộn Rồi Mà Sao Còn")
        ));

        songMap.put("Mỹ Linh", Arrays.asList(
                new Song("Chat Với Mozart"),
                new Song("Điều Giản Dị"),
                new Song("Hoa Sữa"),
                new Song("Tôi Sẽ Không Buông Tay"),
                new Song("Bên Em Là Anh")
        ));

        songMap.put("Noo Phước Thịnh", Arrays.asList(
                new Song("Cause I Love You"),
                new Song("Đừng Như Thói Quen"),
                new Song("Vì Anh Mãi Yêu Em"),
                new Song("Yêu Một Người Có Lẽ"),
                new Song("Người Lạ Ơi")
        ));

        songMap.put("Đức Phúc", Arrays.asList(
                new Song("Anh Không Đòi Quà"),
                new Song("Sau Tất Cả"),
                new Song("Ta Nói Chuyện Mình Nhé"),
                new Song("Đánh Đổi"),
                new Song("Chỉ Vì Một Chữ Duyên")
        ));

        songMap.put("Jack", Arrays.asList(
                new Song("Hoa Hải Đường"),
                new Song("Sóng Gió"),
                new Song("Bạc Phận"),
                new Song("Việt Nam Tôi"),
                new Song("Ngày Chưa Giông Bão")
        ));

        songMap.put("Đan Trường", Arrays.asList(
                new Song("Ngày Mai"),
                new Song("Tình Yêu Không Lối Thoát"),
                new Song("Nhớ Về Em"),
                new Song("Con Đường Không Em"),
                new Song("Đường Tình Đôi Ngã")
        ));

        songMap.put("Erik", Arrays.asList(
                new Song("Ghen"),
                new Song("Anh Không Muốn Đâu"),
                new Song("Thì Thôi"),
                new Song("Vì Tôi Còn Sống"),
                new Song("Không Thể Cùng Nhau Suốt Kiếp")
        ));

        songMap.put("Trung Quân", Arrays.asList(
                new Song("Có Chàng Trai Viết Lên Cây"),
                new Song("Rồi Tới Luôn"),
                new Song("Đã Lỡ Yêu Em Rồi"),
                new Song("Trao"),
                new Song("Mắt Biếc")
        ));

        List<Song> songs = songMap.get(singerName);
        return songs != null ? songs : new ArrayList<>();
    }
}
