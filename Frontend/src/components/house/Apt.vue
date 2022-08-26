<template>
  <div>
    <div>
      <!-- select -->
      <div class="section2">
        <div
          id="searchBox"
          class="d-flex m-auto justify-content-center"
          style="background-color: #d8d5d2"
        >
          <form id="searchForm">
            <select class="form-select" id="sido" v-model="sido">
              <option value="0">시/도</option>
              <option
                v-for="(sido, index) in sidoList"
                :key="index"
                :value="sido.code"
              >
                {{ sido.name }}
              </option>
            </select>

            <select class="form-select" id="gugun" v-model="gugun">
              <option value="0">구/군</option>
              <option
                v-for="(gugun, index) in gugunList"
                :key="index"
                :value="gugun.code"
              >
                {{ gugun.name }}
              </option>
            </select>

            <select
              class="form-select d-inline"
              id="dongName"
              v-model="dongName"
            >
              <option value="">읍/면/동</option>
              <option
                v-for="(dong, index) in dongList"
                :key="index"
                :value="dong.name"
              >
                {{ dong.name }}
              </option>
            </select>
          </form>

          <form>
            <div class="input-group" id="searchApt">
              <input
                v-model="searchName"
                type="text"
                class="form-control"
                placeholder="Apartment Name"
                aria-label="Recipient's username"
                aria-describedby="button-addon2"
              />
              <button
                class="btn btn-outline-secondary"
                type="button"
                id="button-addon2"
                @click="search"
              >
                Search
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>

    <div id="Info">
      <div class="card bg-black" id="information">
        <!-- 왼쪽 구역 -->
        <ul
          style="padding: 5px"
          id="placesList"
          v-for="(Apt, index) in AptList"
          :key="index"
          @click="aptClick(Apt.no)"
        >
          <li class="item">
            <div class="info">
              <p style="font-weight: bold; font-size: large">
                {{ Apt.AptName }}
              </p>
            </div>
          </li>
        </ul>
      </div>

      <div class="map_wrap">
        <div id="map"></div>
        <div>
          <ul id="category" style="text-align: center; text-weight: bolder">
            <li
              style="cursor: pointer"
              id="BK9"
              data-order="0"
              @click="onClickCategory('BK9')"
            >
              <span
                style="width: 50px; height: 50px"
                class="category_bg bank font-bold mt-2"
              >
                <img src="../../assets/icon/apt/bank.png" alt="bank" />
              </span>
              은행
            </li>
            <li
              style="cursor: pointer"
              id="MT1"
              data-order="1"
              @click="onClickCategory('MT1')"
            >
              <span
                style="width: 50px; height: 50px"
                class="category_bg mart mt-2"
              >
                <img src="../../assets/icon/apt/mart.png" alt="mart" />
              </span>
              마트
            </li>
            <li style="cursor: pointer" id="PM9" data-order="2">
              <span
                style="width: 50px; height: 50px"
                class="category_bg pharmacy mt-2"
                @click="onClickCategory('PM9')"
                ><img src="../../assets/icon/apt/hospital.png" alt="hospital"
              /></span>
              약국
            </li>
            <li
              style="cursor: pointer"
              id="OL7"
              data-order="3"
              @click="onClickCategory('OL7')"
            >
              <span
                style="width: 50px; height: 50px"
                class="category_bg oil mt-2"
                ><img src="../../assets/icon/apt/oil.png" alt="oil"
              /></span>
              주유소
            </li>
            <li
              style="cursor: pointer"
              id="CE7"
              data-order="4"
              @click="onClickCategory('CE7')"
            >
              <span
                style="width: 50px; height: 50px"
                class="category_bg cafe mt-2"
                ><img src="../../assets/icon/apt/cafe.png" alt="cafe"
              /></span>
              카페
            </li>
            <li
              style="cursor: pointer"
              id="CS2"
              data-order="5"
              @click="onClickCategory('CS2')"
            >
              <span
                style="width: 50px; height: 50px"
                class="category_bg store mt-2"
                ><img src="../../assets/icon/apt/store.png" alt="store"
              /></span>
              편의점
            </li>
          </ul>
        </div>

        <div id="menu_wrap" class="bg_white" v-show="true">
          <div class="option">
            <div>
              <form>
                <div class="input-group mb-3">
                  <input
                    id="keyword"
                    type="text"
                    class="form-control"
                    placeholder="Keyword"
                    aria-label="Recipient's username"
                    aria-describedby="button-addon2"
                    style="padding-left: 5px"
                  />
                  <button
                    @click="searchPlace"
                    class="btn btn-outline-secondary"
                    type="button"
                    id="button-addon2"
                    style="
                      font-size: 12pt;
                      padding-top: 2px;
                      padding-bottom: 2px;
                      padding-left: 2px;
                      padding-right: 2px;
                    "
                  >
                    Search
                  </button>
                </div>
                <!-- 키워드 : -->
                <!-- <input type="text" value="" id="keyword" size="18" /> -->
                <!-- <input
                  id="keyword"
                  type="text"
                  class="form-control"
                  width="17"
                  size="17"
                />
                <button
                  type="button"
                  style="
                    font-size: 12pt;
                    padding-top: 2px;
                    padding-bottom: 2px;
                    padding-left: 2px;
                    padding-right: 2px;
                  "
                  @click="searchPlace"
                  class="btn btn-outline-secondary"
                >
                  검색하기 -->
                <!-- </button> -->
              </form>
            </div>
          </div>
          <hr />
          <ul
            id="placesList"
            v-for="rs in searchKeyword.results"
            :key="rs.id"
            @click="showPlace(rs)"
          >
            <li class="item">
              <div class="info">
                <h5>{{ rs.place_name }}</h5>
                <span>{{ rs.address_name }}</span>
                <span class="tel">{{ rs.phone }}</span>
              </div>
            </li>
          </ul>
          <div id="pagination"></div>
        </div>
      </div>
    </div>

    <detail-modal></detail-modal>
  </div>
</template>


<script>
import DetailModal from "./modals/DetailModal.vue";

import { Modal } from "bootstrap";

import http from "@/common/axios.js";

import Vue from "vue";
import VueAlertify from "vue-alertify";
Vue.use(VueAlertify);

export default {
  components: { DetailModal },
  data() {
    return {
      map: null,
      detailModal: null,
      lat: 37.6598202,
      lng: 127.0356267,
      markers: [],
      clickmarker: [],
      searchKeyword: {
        keyword: null,
        pgn: null,
        results: [],
      },
      keywordmarkers: [],
      iskeyword: "",

      //place
      placeMarkers: [],
      currCategory: "",
      placeOverlay: null,
      ps: null,
      contentNode: null,
    };
  },

  mounted() {
    if (!window.kakao || !window.kakao.maps) {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=f007d231b738fb07ad65258951c02f45&libraries=services";
      document.head.appendChild(script);
    } else {
      this.initMap();
    }
    this.detailModal = new Modal(document.getElementById("detailModal"));
  },
  methods: {
    search() {
      console.log(this.searchName);
      this.getAptList_name();
    },
    getSidoList() {
      this.$store.dispatch("getSidoList");
    },
    getGugunList() {
      this.$store.dispatch("getGugunList");
    },
    getDongList() {
      this.$store.dispatch("getDongList");
    },

    getAptList_dong() {
      this.$store.dispatch("getAptList_dong");
    },

    getAptList_name() {
      this.$store.dispatch("getAptList_name");
    },

    getHouseDetail() {
      this.$store.dispatch("getHouseDetail");
    },
    getHouseDealList() {
      this.$store.dispatch("getHouseDealList");
    },

    initMap() {
      const container = document.getElementById("map");
      const options = {
        center: new kakao.maps.LatLng(this.lat, this.lng),
        level: 3,
      };

      this.getAptList_dong();

      //지도 객체를 등록합니다.
      //지도 객체는 반응형 관리 대상이 아니므로 initMap에서 선언합니다.
      this.map = new kakao.maps.Map(container, options);

      var markerPosition = new kakao.maps.LatLng(33.450701, 126.570667);
      this.clickmarker = new kakao.maps.Marker({ position: markerPosition });

      // place 추가
      // 마커를 클릭했을 때 해당 장소의 상세정보를 보여줄 커스텀오버레이입니다
      this.ps = new window.kakao.maps.services.Places(this.map);
      this.placeOverlay = new kakao.maps.CustomOverlay({ zIndex: 1 });
      this.contentNode = document.createElement("div"); // 커스텀 오버레이의 컨텐츠 엘리먼트 입니다

      // 커스텀 오버레이의 컨텐츠 노드에 css class를 추가합니다
      this.contentNode.className = "placeinfo_wrap";

      // 지도에 idle 이벤트를 등록합니다
      kakao.maps.event.addListener(this.map, "idle", this.searchPlaces);

      // 커스텀 오버레이의 컨텐츠 노드에 mousedown, touchstart 이벤트가 발생했을때
      // 지도 객체에 이벤트가 전달되지 않도록 이벤트 핸들러로 kakao.maps.event.preventMap 메소드를 등록합니다
      this.addEventHandle(
        this.contentNode,
        "mousedown",
        kakao.maps.event.preventMap
      );
      this.addEventHandle(
        this.contentNode,
        "touchstart",
        kakao.maps.event.preventMap
      );
      // 커스텀 오버레이 컨텐츠를 설정합니다
      this.placeOverlay.setContent(this.contentNode);

      // 각 카테고리에 클릭 이벤트를 등록합니다
      //this.addCategoryClickEvent();
    },

    setCenter(lat, lng) {
      // 이동할 위도 경도 위치를 생성합니다
      var moveLatLon = new kakao.maps.LatLng(lat, lng);

      // 지도 중심을 이동 시킵니다
      this.map.setCenter(moveLatLon);
    },
    panTo(lat, lng) {
      // 이동할 위도 경도 위치를 생성합니다
      var moveLatLon = new kakao.maps.LatLng(lat, lng);

      // 지도 중심을 부드럽게 이동시킵니다
      // 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
      this.map.panTo(moveLatLon);
    },

    //아파트들 마크 표시
    AptMarker() {
      if (this.AptList != null) {
        //현재 표시되어있는 마커들 제거
        if (this.markers.length > 0) {
          this.markers.forEach((item) => {
            item.setMap(null);
          });
        }
        this.markers = [];

        //마커를 뿌릴 위치를 저장(아파트 위치들)
        const positions = [];

        for (var i = 0; i < this.AptList.length; i++) {
          positions.push({
            content:
              '<div class="placeinfo" style="width:200px; height:30px; text-align:center; font-weight:bold">' +
              // '   <a class="title2"' +
              // ' title="' +
              // this.AptList[i].AptName +
              // '">' +
              // this.AptList[i].AptName +
              // "</a>" +
              '    <span title="' +
              this.AptList[i].AptName +
              '">' +
              this.AptList[i].AptName +
              "</span>" +
              "</div>",
            // '<div class="positionMarker"> <span>' +
            // this.AptList[i].AptName +
            // "</span></div>",
            title: this.AptList[i].no,
            latlng: new kakao.maps.LatLng(
              this.AptList[i].lat,
              this.AptList[i].lng
            ),
          });
        }
        console.log(positions.length);

        // const imgSrc =
        // ("https://cdn-icons.flaticon.com/png/512/5241/premium/5241741.png?token=exp=1653380571~hmac=2d30e56e0ba547acadd4bc493963253c");
        const imgSrc =
          "https://cdn-icons-png.flaticon.com/512/3447/3447502.png";
        // const imgSrc =
        //   "https://cdn-icons-png.flaticon.com/512/2301/2301915.png";
        const imgSize = new kakao.maps.Size(50, 50);
        // 마커 이미지를 생성합니다
        const markerImage = new kakao.maps.MarkerImage(imgSrc, imgSize);

        //마커 표시하기
        positions.forEach((position) => {
          // 마커를 생성합니다
          const marker = new kakao.maps.Marker({
            map: this.map, // 마커를 표시할 지도
            position: position.latlng, // 마커를 표시할 위치
            title: position.title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
            image: markerImage, // 마커 이미지
          });

          this.markers.push(marker);

          const infowindow = new kakao.maps.InfoWindow({
            content: position.content, // 인포윈도우에 표시할 내용
          });

          kakao.maps.event.addListener(marker, "mouseover", () => {
            infowindow.open(this.map, marker);
          });

          kakao.maps.event.addListener(marker, "mouseout", () => {
            infowindow.close();
          });

          kakao.maps.event.addListener(marker, "click", () => {
            this.aptDetail(position.title);
          });
        });

        this.panTo(this.AptList[0].lat, this.AptList[0].lng);
      } else {
        //현재 표시되어있는 마커들 제거
        if (this.markers.length > 0) {
          this.markers.forEach((item) => {
            item.setMap(null);
          });
        }
        this.markers = [];

        this.panTo(37.6598202, 127.0356267);
      }
    },

    aptDetail(no) {
      this.houseNo = no;
      console.log(this.houseNo);
      this.getHouseDetail();
      this.getHouseDealList();
      this.detailModal.show();
    },

    aptClick(no) {
      this.houseNo = no;
      this.getHouseDetail();
    },

    searchPlace() {
      const keyword = document.getElementById("keyword").value.trim();

      if (keyword.length === 0) {
        return;
      }

      // 장소 검색 객체를 생성합니다
      const ps_2 = new window.kakao.maps.services.Places();

      // 키워드로 장소를 검색합니다
      ps_2.keywordSearch(keyword, (data, status, pgn) => {
        this.iskeyword = keyword;
        this.searchKeyword.keyword = keyword;
        this.searchKeyword.pgn = pgn;
        this.searchKeyword.results = data;
      });
    },

    showPlace(place) {
      console.log(place);
      this.panTo(place.y, place.x);
    },

    keywordMarker() {
      if (this.searchKeyword.results != null) {
        if (this.keywordmarkers.length > 0) {
          this.keywordmarkers.forEach((item) => {
            item.setMap(null);
          });
        }
        this.keywordmarkers = [];

        let positions = [];

        this.searchKeyword.results.forEach((rs) => {
          positions.push({
            content:
              '<div class="placeinfo">' +
              '   <a class="title2" href="' +
              rs.place_url +
              '" target="_blank" title="' +
              rs.place_name +
              '">' +
              rs.place_name +
              "</a>" +
              '    <span title="' +
              rs.address_name +
              '">' +
              rs.address_name +
              "</span>" +
              '    <span class="tel">' +
              rs.phone +
              "</span>" +
              "</div>",

            // content:
            //   '<div style="padding:5px; font-size: 15px; border-radius: 30px;">' +
            //   rs.place_name +
            //   "</div>",
            title: rs.place_name,
            latlng: new kakao.maps.LatLng(rs.y, rs.x),
          });
        });

        for (let i = 0; i < positions.length; i++) {
          const imageSrc =
            "https://cdn-icons.flaticon.com/png/512/2859/premium/2859734.png?token=exp=1653574733~hmac=b0922e97d68343dafe06b6d36dd6686d"; // 마커 이미지 url, 스프라이트 이미지를 씁니다
          const imageSize = new kakao.maps.Size(50, 50); // 마커 이미지의 크기
          // 마커 이미지를 생성합니다
          const markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

          const marker = new kakao.maps.Marker({
            map: this.map, // 마커를 표시할 지도
            position: positions[i].latlng, // 마커를 표시할 위치
            title: positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
            image: markerImage, // 마커 이미지
          });

          const infowindow = new kakao.maps.InfoWindow({
            content: positions[i].content, // 인포윈도우에 표시할 내용
          });

          kakao.maps.event.addListener(marker, "mouseover", () => {
            infowindow.open(this.map, marker);
          });

          kakao.maps.event.addListener(marker, "mouseout", () => {
            infowindow.close();
          });

          this.keywordmarkers.push(marker);

          this.panTo(
            this.searchKeyword.results[0].y,
            this.searchKeyword.results[0].x
          );
        }
      } else {
        //현재 표시되어있는 마커들 제거
        if (this.keywordmarkers.length > 0) {
          this.keywordmarkers.forEach((item) => {
            item.setMap(null);
          });
        }
        this.keywordmarkers = [];
      }
    },
    // place 추가 함수

    // 엘리먼트에 이벤트 핸들러를 등록하는 함수입니다
    addEventHandle(target, type, callback) {
      if (target.addEventListener) {
        target.addEventListener(type, callback);
      } else {
        target.attachEvent("on" + type, callback);
      }
    },

    // 카테고리 검색을 요청하는 함수입니다
    searchPlaces() {
      if (!this.currCategory) {
        return;
      }

      // 커스텀 오버레이를 숨깁니다
      this.placeOverlay.setMap(null);

      // 지도에 표시되고 있는 마커를 제거합니다
      this.removePlaceMarker();

      this.ps.categorySearch(this.currCategory, this.placesSearchCB, {
        useMapBounds: true,
      });
    },

    // 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
    placesSearchCB(data, status) {
      if (status === kakao.maps.services.Status.OK) {
        // 정상적으로 검색이 완료됐으면 지도에 마커를 표출합니다
        this.displayPlaces(data);
      } else if (status === kakao.maps.services.Status.ZERO_RESULT) {
        // 검색결과가 없는경우 해야할 처리가 있다면 이곳에 작성해 주세요
      } else if (status === kakao.maps.services.Status.ERROR) {
        // 에러로 인해 검색결과가 나오지 않은 경우 해야할 처리가 있다면 이곳에 작성해 주세요
      }
    },
    // 지도에 마커를 표출하는 함수입니다
    displayPlaces(places) {
      // 몇번째 카테고리가 선택되어 있는지 얻어옵니다
      // 이 순서는 스프라이트 이미지에서의 위치를 계산하는데 사용됩니다
      var order = document
        .getElementById(this.currCategory)
        .getAttribute("data-order");

      for (var i = 0; i < places.length; i++) {
        // 마커를 생성하고 지도에 표시합니다
        var pmarker = this.addPlaceMarker(
          new kakao.maps.LatLng(places[i].y, places[i].x),
          order
        );

        // 마커와 검색결과 항목을 클릭 했을 때
        // 장소정보를 표출하도록 클릭 이벤트를 등록합니다
        var $this = this;
        (function (pmarker, place) {
          kakao.maps.event.addListener(pmarker, "click", function () {
            $this.displayPlaceInfo(place);
          });
        })(pmarker, places[i]);

        kakao.maps.event.addListener($this.map, "click", function () {
          $this.placeOverlay.setMap(null);
        });
      }
    },

    // 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
    addPlaceMarker(position, order) {
      var imageSrc = [
          "https://cdn-icons.flaticon.com/png/512/5695/premium/5695071.png?token=exp=1653574793~hmac=5d8c3ea8d9f1c2330ee87590608f37e2",
          "https://cdn-icons.flaticon.com/png/512/5695/premium/5695140.png?token=exp=1653574811~hmac=17c62563e7c6326d7811ec492476bebb",
          "https://cdn-icons.flaticon.com/png/512/5693/premium/5693852.png?token=exp=1653574824~hmac=8dd343e033a7bda30906873ba18737e5",
          "https://cdn-icons.flaticon.com/png/512/5695/premium/5695643.png?token=exp=1653574836~hmac=821be1754fa685b3b291702b2bc5930d",
          "https://cdn-icons.flaticon.com/png/512/5695/premium/5695680.png?token=exp=1653574846~hmac=f797c598cc91bd4983280af785ec6620",
          "https://cdn-icons.flaticon.com/png/512/5693/premium/5693840.png?token=exp=1653574857~hmac=fc61f97b5d9847d0e761674c2802d6f9",
        ],
        imageSize = new kakao.maps.Size(40, 40), // 마커 이미지의 크기
        imgOptions = {
          // spriteSize: new kakao.maps.Size(72, 208), // 스프라이트 이미지의 크기
          // spriteOrigin: new kakao.maps.Point(46, order * 36), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
          offset: new kakao.maps.Point(11, 28), // 마커 좌표에 일치시킬 이미지 내에서의 좌표
        },
        markerImage = new kakao.maps.MarkerImage(
          imageSrc[order],
          imageSize,
          imgOptions
        ),
        pmarker = new kakao.maps.Marker({
          position: position, // 마커의 위치
          image: markerImage,
        });

      pmarker.setMap(this.map); // 지도 위에 마커를 표출합니다
      this.placeMarkers.push(pmarker); // 배열에 생성된 마커를 추가합니다

      return pmarker;
    },
    // 지도 위에 표시되고 있는 마커를 모두 제거합니다
    removePlaceMarker() {
      for (var i = 0; i < this.placeMarkers.length; i++) {
        this.placeMarkers[i].setMap(null);
      }
      this.placeMarkers = [];
    },

    // 클릭한 마커에 대한 장소 상세정보를 커스텀 오버레이로 표시하는 함수입니다
    displayPlaceInfo(place) {
      var content =
        '<div class="placeinfo">' +
        '   <a class="title" href="' +
        place.place_url +
        '" target="_blank" title="' +
        place.place_name +
        '">' +
        place.place_name +
        "</a>";

      if (place.road_address_name) {
        content +=
          '    <span title="' +
          place.road_address_name +
          '">' +
          place.road_address_name +
          "</span>" +
          '  <span class="jibun" title="' +
          place.address_name +
          '">(지번 : ' +
          place.address_name +
          ")</span>";
      } else {
        content +=
          '    <span title="' +
          place.address_name +
          '">' +
          place.address_name +
          "</span>";
      }

      content +=
        '    <span class="tel">' +
        place.phone +
        "</span>" +
        "</div>" +
        '<div class="after"></div>';

      this.contentNode.innerHTML = content;
      this.placeOverlay.setPosition(new kakao.maps.LatLng(place.y, place.x));
      this.placeOverlay.setMap(this.map);
    },
    // 각 카테고리에 클릭 이벤트를 등록합니다
    // addCategoryClickEvent() {
    //   var category = document.getElementById("category");
    //   var children = category.children;

    //   for (var i = 0; i < children.length; i++) {
    //     // children[i].onclick = this.onClickCategory;
    //     children[i].onclick = this.onClickCategory(children[i]);
    //   }
    // },
    // 카테고리를 클릭했을 때 호출되는 함수입니다
    onClickCategory(id) {
      var el = document.getElementById(id);
      console.log("onClickCategory : ");
      console.log(el);
      console.log(el.className);
      // var id = el.id,
      var className = el.className;
      // var className = "on";

      this.placeOverlay.setMap(null);
      console.log("onclickCategory : " + " " + id + " " + className);

      if (className === "on") {
        console.log("if");
        this.currCategory = "";
        this.changeCategoryClass();
        this.removePlaceMarker();
      } else {
        console.log("else");
        this.currCategory = id;
        this.changeCategoryClass(el);
        this.searchPlaces();
      }
    },

    // 클릭된 카테고리에만 클릭된 스타일을 적용하는 함수입니다
    changeCategoryClass(el) {
      var category = document.getElementById("category"),
        children = category.children,
        i;

      for (i = 0; i < children.length; i++) {
        children[i].className = "";
      }

      if (el) {
        el.className = "on";
      }
    },
  },
  created() {
    this.getSidoList();
  },
  computed: {
    sidoList() {
      return this.$store.getters.getSidoList;
    },
    gugunList() {
      return this.$store.getters.getGugunList;
    },
    dongList() {
      return this.$store.getters.getDongList;
    },
    AptList() {
      return this.$store.getters.getAptList;
    },
    HouseDetail() {
      return this.$store.getters.getHouseDetail;
    },
    HouseDealList() {
      return this.$store.getters.getHouseDealList;
    },
    sido: {
      get() {
        return this.$store.state.address.sido;
      },
      set(sido) {
        this.$store.commit("SET_ADDRESS_SIDO", sido);
      },
    },
    gugun: {
      get() {
        return this.$store.state.address.gugun;
      },
      set(gugun) {
        this.$store.commit("SET_ADDRESS_GUGUN", gugun);
      },
    },
    dong: {
      get() {
        return this.$store.state.address.dong;
      },
      set(dong) {
        this.$store.commit("SET_ADDRESS_DONG", dong);
      },
    },
    dongName: {
      get() {
        return this.$store.state.address.dongName;
      },
      set(dongName) {
        this.$store.commit("SET_ADDRESS_DONGNAME", dongName);
      },
    },
    searchName: {
      get() {
        return this.$store.state.address.searchName;
      },
      set(searchName) {
        this.$store.commit("SET_ADDRESS_SEARCHNAME", searchName);
      },
    },
    houseNo: {
      get() {
        return this.$store.state.address.houseNo;
      },
      set(houseNo) {
        this.$store.commit("SET_ADDRESS_HOUSENO", houseNo);
      },
    },
  },
  watch: {
    sido: function () {
      console.log("watch : sido() " + this.sido);
      if (this.sido != "0") this.getGugunList();
    },
    gugun: function () {
      console.log("watch : gugun() " + this.gugun);
      if (this.gugun != "0") this.getDongList();
    },
    dong: function () {
      console.log("watch : dong() " + this.dong);
      if (this.dong != "0") this.getAptList();
    },
    dongName: function () {
      console.log("watch : dongName() " + this.dongName);
      if (this.dongName != "0") {
        this.clickmarker.setMap(null);
        this.getAptList_dong();
      }
    },
    AptList: function () {
      this.AptMarker();
    },

    HouseDetail: function () {
      this.clickmarker.setMap(null);

      const clickImgSrc =
        "https://cdn-icons.flaticon.com/png/512/4551/premium/4551325.png?token=exp=1653574665~hmac=4a46efcaf18d4480762d349a77f20df6";
      const clickImgSize = new kakao.maps.Size(70, 70);
      // 마커 이미지를 생성합니다
      const clickMarkerImage = new kakao.maps.MarkerImage(
        clickImgSrc,
        clickImgSize
      );
      //마커가 표시될 위치입니다
      const ClickPosition = new kakao.maps.LatLng(
        this.HouseDetail.lat,
        this.HouseDetail.lng
      );

      this.clickmarker = new kakao.maps.Marker({
        position: ClickPosition,
        image: clickMarkerImage,
      });

      // 마커가 지도 위에 표시되도록 설정합니다
      this.clickmarker.setMap(this.map);

      kakao.maps.event.addListener(this.clickmarker, "click", () => {
        this.aptDetail(this.HouseDetail.no);
      });

      this.panTo(this.HouseDetail.lat, this.HouseDetail.lng);
    },
    iskeyword: function () {
      this.keywordMarker();
    },
  },
};
</script>


<style scoped>
.section2 {
  margin-top: 150px;
}

#map {
  width: 100%;
  height: 100%;
  display: flex;
  margin: auto;
}

#searchBox {
  padding: 30px 50px 20px 50px;
  margin: auto;
}
#searchForm {
  /* background-color: #786d64; */
}

#searchForm #sido {
  background-color: #786d64;
  text-align: center;
  font-size: medium;
  width: 160px;
  height: 40px;
}
#searchForm #gugun {
  background-color: #786d64;
  text-align: center;
  font-size: medium;
  width: 160px;
  height: 40px;
}
#searchForm #dongName {
  background-color: #786d64;
  text-align: center;
  font-size: medium;
  width: 160px;
  height: 40px;
}
select {
  background-color: black;
  color: white;
  padding: 5px 5px 5px 5px;
  margin: 5px 5px 5px 5px;
  border-radius: 5px;
  width: 100px;
  height: 30px;
  font-size: small;
}

#searchApt {
  font-size: small;
  margin: 5px 0px 0px 80px;
}

#Info {
  display: flex;
  height: 1000px;
}

#information {
  width: 15%;
  color: #786d64;
  font-size: 25px;
  display: flex;
  padding: 20px 20px 20px 20px;
  overflow: auto;
  border-radius: 0px;
  background-color: #d8d5d2;
}

#information::-webkit-scrollbar {
  background-color: #786d64;
}

#information::-webkit-scrollbar-thumb {
  background-color: grey;
  border-radius: 10px;
}

#information::-webkit-scrollbar-track {
  background-color: grey;
  background-color: #786d64;
  border-radius: 10px;
  box-shadow: inset 0px 0px 5px white;
}

#information button {
  margin: 10px 5px 10px 5px;
}

.map_wrap,
.map_wrap * {
  margin: 0;
  padding: 0;
  font-family: "Malgun Gothic", dotum, "돋움", sans-serif;
  font-size: 12px;
}
.map_wrap a,
.map_wrap a:hover,
.map_wrap a:active {
  color: #000;
  text-decoration: none;
}
.map_wrap {
  position: relative;
  width: 100%;
  height: 100%;
}
#menu_wrap {
  position: absolute;
  top: 0;
  right: 0;
  bottom: 0;
  width: 350px;
  margin: 10px 0 30px 10px;
  padding: 5px;
  overflow-y: auto;
  background: rgba(255, 255, 255, 0.9);
  z-index: 1;
  font-size: 12px;
  border-radius: 10px;
}
.bg_white {
  background: #fff;
}
#menu_wrap hr {
  display: block;
  height: 1px;
  border: 0;
  border-top: 2px solid #5f5f5f;
  margin: 3px 0;
}
#menu_wrap .option {
  text-align: center;
}
#menu_wrap .option p {
  margin: 10px 0;
}
#menu_wrap .option button {
  margin-left: 5px;
}
#placesList li {
  list-style: none;
}
#placesList .item {
  position: relative;
  border-bottom: 1px solid #888;
  overflow: hidden;
  cursor: pointer;
  min-height: 65px;
}
#placesList .item span {
  display: block;
  margin-top: 4px;
}
#placesList .item h5,
#placesList .item .info {
  text-overflow: ellipsis;
  overflow: hidden;
  white-space: nowrap;
}
#placesList .item .info {
  padding: 10px 0 10px 55px;
}
#placesList .info .gray {
  color: #8a8a8a;
}
#placesList .info .jibun {
  padding-left: 26px;
  background: url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_jibun.png)
    no-repeat;
}
#placesList .info .tel {
  color: #009900;
}
#placesList .item .markerbg {
  float: left;
  position: absolute;
  width: 36px;
  height: 37px;
  margin: 10px 0 0 10px;
  background: url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png)
    no-repeat;
}
/* #placesList .item .marker_1 {
  background-position: 0 -10px;
}
#placesList .item .marker_2 {
  background-position: 0 -56px;
}
#placesList .item .marker_3 {
  background-position: 0 -102px;
}
#placesList .item .marker_4 {
  background-position: 0 -148px;
}
#placesList .item .marker_5 {
  background-position: 0 -194px;
}
#placesList .item .marker_6 {
  background-position: 0 -240px;
}
#placesList .item .marker_7 {
  background-position: 0 -286px;
}
#placesList .item .marker_8 {
  background-position: 0 -332px;
}
#placesList .item .marker_9 {
  background-position: 0 -378px;
}
#placesList .item .marker_10 {
  background-position: 0 -423px;
}
#placesList .item .marker_11 {
  background-position: 0 -470px;
}
#placesList .item .marker_12 {
  background-position: 0 -516px;
}
#placesList .item .marker_13 {
  background-position: 0 -562px;
}
#placesList .item .marker_14 {
  background-position: 0 -608px;
}
#placesList .item .marker_15 {
  background-position: 0 -654px;
} */
#pagination {
  margin: 10px auto;
  text-align: center;
}
#pagination a {
  display: inline-block;
  margin-right: 10px;
}
#pagination .on {
  font-weight: bold;
  cursor: default;
  color: #777;
}
</style>

<style >
.map_wrap,
.map_wrap * {
  margin: 0;
  padding: 0;
  font-family: "Malgun Gothic", dotum, "돋움", sans-serif;
  font-size: 12px;
}
.map_wrap {
  position: relative;
  width: 100%;
  height: 350px;
}
#category {
  width: 70px;
  height: 480px;
  position: absolute;
  top: 10px;
  left: 10px;
  border-radius: 5px;
  border: 1px solid #909090;
  box-shadow: 0 1px 1px rgba(0, 0, 0, 0.4);
  background: #fff;
  overflow: hidden;
  z-index: 2;
}
/* #category li {float:left;list-style: none;width:50px;px;border-right:1px solid #acacac;padding:6px 0;text-align: center; cursor: pointer;} */
#category li.on {
  background: #eee;
}
#category li:hover {
  background: #ffe6e6;
  border-left: 1px solid #acacac;
  margin-left: -1px;
}
#category li:last-child {
  margin-right: 0;
  border-right: 0;
}
#category li span {
  display: block;
  margin: 0 auto 3px;
  width: 27px;
  height: 28px;
}
/* #category li .category_bg {
  background: url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_category.png)
    no-repeat;
}
#category li .bank {
  background-position: -10px 0;
  background: url("../../assets/icon/apt/bank.png");
} */
#category li .mart {
  /* background-position: -10px -36px; */
}
#category li .pharmacy {
  /* background-position: -10px -72px; */
}
#category li .oil {
  /* background-position: -10px -108px; */
}
#category li .cafe {
  /* background-position: -10px -144px; */
}
#category li .store {
  /* background-position: -10px -180px; */
}
#category li.on .category_bg {
  /* background-position-x: -46px; */
}
.placeinfo_wrap {
  position: absolute;
  bottom: 28px;
  left: -150px;
  width: 300px;
}
.placeinfo {
  position: relative;
  width: 100%;
  border-radius: 6px;
  border: 1px solid #ccc;
  border-bottom: 2px solid #ddd;
  padding-bottom: 10px;
  background: #fff;
}
.placeinfo:nth-of-type(n) {
  border: 0;
  box-shadow: 0px 1px 2px #888;
}
.placeinfo_wrap .after {
  content: "";
  position: relative;
  margin-left: -12px;
  left: 50%;
  width: 22px;
  height: 12px;
  background: url("https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png");
}
.placeinfo a,
.placeinfo a:hover,
.placeinfo a:active {
  color: #fff;
  text-decoration: none;
}
.placeinfo a,
.placeinfo span {
  display: block;
  text-overflow: ellipsis;
  overflow: hidden;
  white-space: nowrap;
}
.placeinfo span {
  margin: 5px 5px 0 5px;
  cursor: default;
  font-size: 13px;
}
.placeinfo .title {
  font-weight: bold;
  font-size: 14px;
  border-radius: 6px 6px 0 0;
  margin: -1px -1px 0 -1px;
  padding: 10px;
  color: #fff;
  background: #d95050;
  background: #d95050
    url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/arrow_white.png)
    no-repeat right 14px center;
}
.placeinfo .title2 {
  font-weight: bold;
  font-size: 14px;
  border-radius: 6px 6px 0 0;
  margin: -1px -1px 0 -1px;
  padding: 10px;
  color: #fff;
  background: #786d64;
  background: #786d64
    url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/arrow_white.png)
    no-repeat right 14px center;
}
.placeinfo .tel {
  color: #0f7833;
}
.placeinfo .jibun {
  color: #999;
  font-size: 11px;
  margin-top: 0;
}
</style>

<style >
.positionMarker {
  /* padding: 5px; */
  padding: auto;
  margin: auto;
  font-size: x-large;
  border-radius: 30px;
  text-align: center;
}
</style>