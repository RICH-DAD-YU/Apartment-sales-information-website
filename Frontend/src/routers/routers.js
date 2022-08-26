import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

import BoardMain from "@/components/board/BoardMain.vue";
import Apt from "@/components/house/Apt.vue";
import HappyHouseMain from "@/components/layout/HappyHouseMain.vue";
import Login from "@/components/user/Login.vue";
import User from "@/components/user/User.vue";
import Team from "@/components/team/Team.vue";
import Register from "@/components/user/Register.vue";
import store from "@/store/store.js";

export default new VueRouter({
  routes: [
    {
      path: "/",
      component: HappyHouseMain,
      // beforeEnter: (to, from, next) => {
      //   if (!store.state.login.isLogin) {
      //     next("/login");
      //   } else {
      //     return next();
      //   }
      // },
    },
    {
      path: "/team",
      component: Team,
      // beforeEnter: (to, from, next) => {
      //   if (!store.state.login.isLogin) {
      //     next("/login");
      //   } else {
      //     return next();
      //   }
      // },
    },

    {
      name: "HappyHouseMain",
      path: "/house",
      component: HappyHouseMain,
      // beforeEnter: (to, from, next) => {
      //   if (!store.state.login.isLogin) {
      //     next("/login");
      //   } else {
      //     return next();
      //   }
      // },
    },
    {
      name: "Apt",
      path: "/apt",
      component: Apt,
      // beforeEnter: (to, from, next) => {
      //   if (!store.state.login.isLogin) {
      //     next("/login");
      //   } else {
      //     return next();
      //   }
      // },
    },
    {
      name: "BoardMain",
      path: "/board",
      component: BoardMain,
      // beforeEnter: (to, from, next) => {
      //   if (!store.state.login.isLogin) {
      //     next("/login");
      //   } else {
      //     return next();
      //   }
      // },
    },
    {
      name: "Login",
      path: "/login",
      component: Login,
    },
    {
      name: "Register",
      path: "/register",
      component: Register,
    },
    {
      name: "User",
      path: "/user",
      component: User,
    },
  ],
});
