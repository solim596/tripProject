package com.example.trip.controller;

import com.example.trip.dto.Board;
import com.example.trip.dto.Item;
import com.example.trip.service.BoardService;
import com.example.trip.service.ItemApiService;
import com.example.trip.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {
    private final ItemApiService itemApiService;
    private final BoardService boardService;
    private final ItemService itemService;

    @GetMapping("/")
    public String index(Model model) {

        // 중복 데이터 제거하고 가져오기
        List<Item> tripList = itemApiService.searchItem("추천여행");

        // 최근 게시글 4개 가져오기 List<Board> recentBoard = boardService.getPosts(갯수);
        List<Board> recentBoard = boardService.getPosts(4);

        List<Item> tripItems1 = new ArrayList<>();
        List<Item> tripItems2 = new ArrayList<>();
        List<Item> tripItems3 = new ArrayList<>();
        List<Item> tripItems4 = new ArrayList<>();

        if(tripList.size() > 5) {
            tripItems1 = tripList.subList(3, 11);    // 3 ~ 10번 이미지(8개)
            tripItems2 = tripList.subList(11, 20);   // 11 ~ 19번 이미지(8개)
            tripItems3 = tripList.subList(20, 28);  // 20 ~ 27번 이미지(8개)
            tripItems4 = tripList.subList(28, 35);  // 28 ~ 34번 이미지(8개)
        } else {
            tripItems1 = tripList;
        }


        // API를 통해 각 카테고리별 데이터 가져오기
//        itemApiService.searchItem("추천여행");
//        itemApiService.searchItem("해외여행 특별세일");
//        itemApiService.searchItem("여행 타임특가");
//        itemApiService.searchItem("홈쇼핑 Hit 여행");

        // 최근 게시글 4개 가져오기 List<Board> recentBoard = boardService.getPosts(갯수);
//        List<Board> recentBoard = boardService.getPosts(4);

        // item태이블에 저장된 데이터 불러와서 각 배열에 저장
//        List<Item> tripItems1 = itemService.getItemsByCategory("추천여행");
//        List<Item> tripItems2 = itemService.getItemsByCategory("해외여행 특별세일");
//        List<Item> tripItems3 = itemService.getItemsByCategory("여행 타임특가");
//        List<Item> tripItems4 = itemService.getItemsByCategory("홈쇼핑 Hit 여행");

//        if (tripItems4.size() > 5) {
//            tripItems4 = tripItems4.subList(14, 19);
//        } else {
//            tripItems4 = tripItems4;
//        }

        model.addAttribute("tripItems1", tripItems1);
        model.addAttribute("tripItems2", tripItems2);
        model.addAttribute("tripItems3", tripItems3);
        model.addAttribute("tripItems4", tripItems4);
        model.addAttribute("recentBoard", recentBoard);

        return "index";
    }
}
