import Vue from "vue";
import Vuex from "vuex";
Vue.use(Vuex);

import http from "@/common/axios.js";
import util from "@/common/util.js";

import userStore from "./modules/userStore.js";

export default new Vuex.Store({
  modules: {
    userStore,
  },
  state: {
    // login, NavBar
    login: {
      // NavBar
      isKakao: false,
      isLogin: false,
      userSeq: 0,
      userName: "",

      // Login
      userEmail: "hong@gildong.com",
      userPassword: "1234",
    },
    // HOUSE
    address: {
      sidoList: [],
      sido: "0", // 최초 선택 항목 지정
      gugunList: [],
      gugun: "0",
      dongList: [],
      dong: "0",
      AptList: [],
      dongName: "",
      searchName: "",
      houseNo: "",
      houseDetail: [],
      houseDealList: [],
    },
    // BOARD
    board: {
      // list
      list: [],
      limit: 10,
      offset: 0,
      searchWord: "",

      // pagination
      listRowCount: 10,
      pageLinkCount: 10,
      currentPageIndex: 1,

      totalListItemCount: 0,

      // detail, update, delete

      boardId: 0,
      title: "",
      content: "",
      userName: "",
      regDate: "",
      regTime: "",
      readCount: 0,
      fileList: [],
      sameUser: false,
    },
  },
  // state 상태를 변경하는 유일한 방법
  mutations: {
    SET_LOGIN(state, payload) {
      state.login.isLogin = payload.isLogin;
      state.login.userName = payload.userName;
      state.login.userEmail = payload.userEmail;
      state.login.userPassword = payload.userPassword;
      state.login.userSeq = payload.userSeq;
    },

    SET_LOGOUT(state) {
      state.login.userSeq = "";
      state.login.isLogin = false;
      state.login.isKakao = false;
      state.login.userPassword = "";
      state.login.userName = "";
      state.login.userEmail = "";
    },

    SET_KAKAO(state) {
      state.login.isKakao = true;
      state.login.isLogin = true;
    },

    //HOUSE
    SET_ADDRESS_SIDOlIST(state, payload) {
      state.address.sidoList = payload;
    },
    SET_ADDRESS_GUGUNlIST(state, payload) {
      state.address.gugunList = payload;
    },
    SET_ADDRESS_DONGlIST(state, payload) {
      state.address.dongList = payload;
    },

    SET_ADDRESS_SIDO(state, payload) {
      state.address.sido = payload;

      state.address.gugun = "0";
      state.address.dong = "0";
      state.address.gugunList = [];
      state.address.dongList = [];
    },
    SET_ADDRESS_GUGUN(state, payload) {
      state.address.gugun = payload;

      state.address.dong = "0";
      state.address.dongList = [];
    },
    SET_ADDRESS_DONG(state, payload) {
      state.address.dong = payload;
    },

    SET_ADDRESS_APTLIST(state, payload) {
      state.address.AptList = payload;
    },

    SET_ADDRESS_DONGNAME(state, payload) {
      state.address.dongName = payload;
    },

    SET_ADDRESS_SEARCHNAME(state, payload) {
      state.address.searchName = payload;
    },

    SET_ADDRESS_HOUSENO(state, payload) {
      state.address.houseNo = payload;
    },

    SET_ADDRESS_HOUSEDETAIL(state, payload) {
      state.address.houseDetail = payload;
    },

    SET_ADDRESS_HOUSEDEALLIST(state, payload) {
      state.address.houseDealList = payload;
    },

    // BOARD
    SET_BOARD_LIST(state, list) {
      state.board.list = list;
    },

    SET_BOARD_TOTAL_LIST_ITEM_COUNT(state, count) {
      state.board.totalListItemCount = count;
    },

    SET_BOARD_MOVE_PAGE(state, pageIndex) {
      state.board.offset = (pageIndex - 1) * state.board.listRowCount;
      state.board.currentPageIndex = pageIndex;
    },

    SET_BOARD_DETAIL(state, payload) {
      state.board.boardId = payload.boardId;
      state.board.title = payload.title;
      state.board.content = payload.content;
      state.board.userName = payload.userName;
      state.board.regDate = util.makeDateStr(
        payload.regDt.date.year,
        payload.regDt.date.month,
        payload.regDt.date.day,
        "."
      );
      state.board.regTime = util.makeTimeStr(
        payload.regDt.time.hour,
        payload.regDt.time.minute,
        payload.regDt.time.second,
        ":"
      );
      state.board.readCount = payload.readCount;
      state.board.fileList = payload.fileList;
      state.board.sameUser = payload.sameUser;
    },
    // for UpdateModal title v-modal
    SET_BOARD_TITLE(state, title) {
      state.board.title = title;
    },
  },
  // for async method
  actions: {
    //HOUSE
    async getSidoList(context) {
      try {
        let { data } = await http.get("/sido");
        context.commit("SET_ADDRESS_SIDOlIST", data);
      } catch (error) {
        console.log(error);
      }
    },
    async getGugunList(context) {
      try {
        let { data } = await http.get("/gugun/" + this.state.address.sido);
        console.log(data);
        context.commit("SET_ADDRESS_GUGUNlIST", data);
      } catch (error) {
        console.log(error);
      }
    },
    async getDongList(context) {
      try {
        let { data } = await http.get("/dong/" + this.state.address.gugun);
        console.log(data);
        context.commit("SET_ADDRESS_DONGlIST", data);
      } catch (error) {
        console.log(error);
      }
    },

    async getAptList_dong(context) {
      try {
        let { data } = await http.get("/search/" + this.state.address.dongName);
        console.log(data);
        context.commit("SET_ADDRESS_APTLIST", data);
      } catch (error) {
        console.log(error);
      }
    },

    async getAptList_name(context) {
      try {
        let { data } = await http.get("/NameSearch/" + this.state.address.searchName);
        console.log(data);
        context.commit("SET_ADDRESS_APTLIST", data);
      } catch (error) {
        console.log(error);
      }
    },

    async getHouseDetail(context) {
      try {
        let { data } = await http.get("/houseDetail/" + this.state.address.houseNo);
        console.log(data);
        context.commit("SET_ADDRESS_HOUSEDETAIL", data);
      } catch (error) {
        console.log(error);
      }
    },

    async getHouseDealList(context) {
      try {
        let { data } = await http.get("/detail/" + this.state.address.houseNo);
        console.log(data);
        context.commit("SET_ADDRESS_HOUSEDEALLIST", data);
      } catch (error) {
        console.log(error);
      }
    },

    // BOARD
    async boardList(context) {
      let params = {
        limit: this.state.board.limit,
        offset: this.state.board.offset,
        searchWord: this.state.board.searchWord,
      };

      try {
        let { data } = await http.get("/boards", { params }); // params: params shorthand property, let response 도 제거
        console.log("BoardMainVue: data : ");
        console.log(data);
        if (data.result == "login") {
          router.push("/login");
        } else {
          context.commit("SET_BOARD_LIST", data.list);
          context.commit("SET_BOARD_TOTAL_LIST_ITEM_COUNT", data.count);
        }
      } catch (error) {
        console.error(error);
      }
    },
  },
  getters: {
    isLogin: function (state) {
      return state.login.isLogin;
    },

    //HOUSE
    getSidoList(state) {
      return state.address.sidoList;
    },
    getGugunList(state) {
      return state.address.gugunList;
    },
    getDongList(state) {
      return state.address.dongList;
    },

    getSido(state) {
      return state.address.sido;
    },
    getGugun(state) {
      return state.address.gugun;
    },
    getDong(state) {
      return state.address.dong;
    },

    getAptList(state) {
      return state.address.AptList;
    },

    getDongName(state) {
      return state.address.dongName;
    },

    getSearchName(state) {
      return state.address.searchName;
    },

    getHouseDetail(state) {
      return state.address.houseDetail;
    },

    getHouseNo(state) {
      return state.address.houseNo;
    },

    getHouseDealList(state) {
      return state.address.houseDealList;
    },

    // BOARD
    getBoardList: function (state) {
      return state.board.list;
    },

    // pagination
    getPageCount: function (state) {
      return Math.ceil(state.board.totalListItemCount / state.board.listRowCount);
    },
    getStartPageIndex: function (state) {
      if (state.board.currentPageIndex % state.board.pageLinkCount == 0) {
        //10, 20...맨마지막
        return (
          (state.board.currentPageIndex / state.board.pageLinkCount - 1) *
            state.board.pageLinkCount +
          1
        );
      } else {
        return (
          Math.floor(state.board.currentPageIndex / state.board.pageLinkCount) *
            state.board.pageLinkCount +
          1
        );
      }
    },

    getEndPageIndex: function (state, getters) {
      let ret = 0;
      if (state.board.currentPageIndex % state.board.pageLinkCount == 0) {
        //10, 20...맨마지막
        ret =
          (state.board.currentPageIndex / state.board.pageLinkCount - 1) *
            state.board.pageLinkCount +
          state.board.pageLinkCount;
      } else {
        ret =
          Math.floor(state.board.currentPageIndex / state.board.pageLinkCount) *
            state.board.pageLinkCount +
          state.board.pageLinkCount;
      }
      // 위 오류나는 코드를 아래와 같이 비교해서 처리
      return ret > getters.getPageCount ? getters.getPageCount : ret;
    },

    getPrev: function (state) {
      if (state.board.currentPageIndex <= state.board.pageLinkCount) {
        return false;
      } else {
        return true;
      }
    },

    getNext: function (state, getters) {
      if (
        Math.floor(getters.getPageCount / state.board.pageLinkCount) * state.board.pageLinkCount <
        state.board.currentPageIndex
      ) {
        return false;
      } else {
        return true;
      }
    },
  },
});
