<template>
  <div>
    <nav-bar></nav-bar>
    <router-view></router-view>
    <footer-bar></footer-bar>
    <!-- 별도의 props 와 v-on 필요 없음.
    <nav-bar v-bind:isLogin="isLogin" v-bind:userInfo="userInfo"/>
    <router-view v-on:call-parent-loginSuccess="loginSuccess"></router-view> -->
  </div>
</template>


<script>
import NavBar from "@/components/layout/NavBar.vue";
import FooterBar from "@/components/layout/FooterBar.vue";

export default {
  name: "App",

  components: {
    NavBar,
    FooterBar,
  },
};
</script>


<style>
@import url("../public/assets/css/animate.css");
@import url("../public/assets/css/tailwind.css");
</style>



