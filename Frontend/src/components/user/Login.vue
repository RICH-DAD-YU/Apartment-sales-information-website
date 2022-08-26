<template>
  <div class="login">
    <!-- ====== Forms Section Start -->
    <section class="bg-[#F4F7FF] py-14 lg:py-20">
      <div class="container">
        <div class="-mx-4 flex flex-wrap">
          <div class="w-full px-4">
            <div
              class="
                wow
                fadeInUp
                relative
                mx-auto
                max-w-[525px]
                overflow-hidden
                rounded-lg
                bg-white
                py-14
                px-8
                text-center
                sm:px-12
                md:px-[60px]
              "
              data-wow-delay=".15s"
            >
              <div class="mb-10 text-center">
                <a
                  href="javascript:void(0)"
                  class="mx-auto inline-block max-w-[160px]"
                >
                  <img
                    src="../../../public/assets/images/logo/logo_login.png"
                    alt="logo"
                  />
                </a>
              </div>
              <form>
                <div class="mb-6">
                  <input
                    type="email"
                    placeholder="Email"
                    v-model="$store.state.login.userEmail"
                    class="
                      bordder-[#E9EDF4]
                      outline-none
                      w-full
                      rounded-md
                      border
                      bg-[#FCFDFE]
                      py-3
                      px-5
                      text-base text-body-color
                      placeholder-[#ACB6BE]
                      transition
                      focus:border-primary
                      focus-visible:shadow-none
                    "
                  />
                </div>
                <div class="mb-6">
                  <input
                    type="password"
                    placeholder="Password"
                    v-model="$store.state.login.userPassword"
                    class="
                      bordder-[#E9EDF4]
                      outline-none
                      w-full
                      rounded-md
                      border
                      bg-[#FCFDFE]
                      py-3
                      px-5
                      text-base text-body-color
                      placeholder-[#ACB6BE]
                      transition
                      focus:border-primary
                      focus-visible:shadow-none
                    "
                  />
                </div>
                <div class="mb-10">
                  <!-- <input
                    type="submit"
                    value="Sign In"
                    class="bordder-primary w-full cursor-pointer rounded-md border bg-primary py-3 px-5 text-base text-white transition duration-300 ease-in-out hover:shadow-md"
                  /> -->
                  <button
                    @click.self.prevent="login"
                    class="
                      bordder-primary
                      w-full
                      cursor-pointer
                      rounded-md
                      border
                      py-3
                      px-5
                      text-base text-white
                      transition
                      duration-300
                      ease-in-out
                      hover:shadow-md
                    "
                    style="background-color: #786d64"
                  >
                    Login
                  </button>
                </div>
              </form>
              <p class="mb-6 text-base text-[#adadad]">Connect With</p>
              <ul class="-mx-2 mb-12 flex justify-between">
                <li class="w-full px-2">
                  <img
                    @click="KakaoLogin"
                    class="btn cursor-pointer hover:shadow-md"
                    src="../../assets/kakao/LoginwithKakao.png"
                  />
                </li>
              </ul>
              <p class="text-base text-[#adadad]">
                Not a member yet?
                <router-link
                  to="/register"
                  class="hover:underline"
                  style="color: #786d64"
                >
                  Sign Up
                </router-link>
              </p>

              <div>
                <span class="absolute top-1 right-1">
                  <svg
                    width="40"
                    height="40"
                    viewBox="0 0 40 40"
                    fill="none"
                    xmlns="http://www.w3.org/2000/svg"
                  >
                    <circle
                      cx="1.39737"
                      cy="38.6026"
                      r="1.39737"
                      transform="rotate(-90 1.39737 38.6026)"
                      fill="#3056D3"
                    />
                    <circle
                      cx="1.39737"
                      cy="1.99122"
                      r="1.39737"
                      transform="rotate(-90 1.39737 1.99122)"
                      fill="#3056D3"
                    />
                    <circle
                      cx="13.6943"
                      cy="38.6026"
                      r="1.39737"
                      transform="rotate(-90 13.6943 38.6026)"
                      fill="#3056D3"
                    />
                    <circle
                      cx="13.6943"
                      cy="1.99122"
                      r="1.39737"
                      transform="rotate(-90 13.6943 1.99122)"
                      fill="#3056D3"
                    />
                    <circle
                      cx="25.9911"
                      cy="38.6026"
                      r="1.39737"
                      transform="rotate(-90 25.9911 38.6026)"
                      fill="#3056D3"
                    />
                    <circle
                      cx="25.9911"
                      cy="1.99122"
                      r="1.39737"
                      transform="rotate(-90 25.9911 1.99122)"
                      fill="#3056D3"
                    />
                    <circle
                      cx="38.288"
                      cy="38.6026"
                      r="1.39737"
                      transform="rotate(-90 38.288 38.6026)"
                      fill="#3056D3"
                    />
                    <circle
                      cx="38.288"
                      cy="1.99122"
                      r="1.39737"
                      transform="rotate(-90 38.288 1.99122)"
                      fill="#3056D3"
                    />
                    <circle
                      cx="1.39737"
                      cy="26.3057"
                      r="1.39737"
                      transform="rotate(-90 1.39737 26.3057)"
                      fill="#3056D3"
                    />
                    <circle
                      cx="13.6943"
                      cy="26.3057"
                      r="1.39737"
                      transform="rotate(-90 13.6943 26.3057)"
                      fill="#3056D3"
                    />
                    <circle
                      cx="25.9911"
                      cy="26.3057"
                      r="1.39737"
                      transform="rotate(-90 25.9911 26.3057)"
                      fill="#3056D3"
                    />
                    <circle
                      cx="38.288"
                      cy="26.3057"
                      r="1.39737"
                      transform="rotate(-90 38.288 26.3057)"
                      fill="#3056D3"
                    />
                    <circle
                      cx="1.39737"
                      cy="14.0086"
                      r="1.39737"
                      transform="rotate(-90 1.39737 14.0086)"
                      fill="#3056D3"
                    />
                    <circle
                      cx="13.6943"
                      cy="14.0086"
                      r="1.39737"
                      transform="rotate(-90 13.6943 14.0086)"
                      fill="#3056D3"
                    />
                    <circle
                      cx="25.9911"
                      cy="14.0086"
                      r="1.39737"
                      transform="rotate(-90 25.9911 14.0086)"
                      fill="#3056D3"
                    />
                    <circle
                      cx="38.288"
                      cy="14.0086"
                      r="1.39737"
                      transform="rotate(-90 38.288 14.0086)"
                      fill="#3056D3"
                    />
                  </svg>
                </span>
                <span class="absolute left-1 bottom-1">
                  <svg
                    width="29"
                    height="40"
                    viewBox="0 0 29 40"
                    fill="none"
                    xmlns="http://www.w3.org/2000/svg"
                  >
                    <circle
                      cx="2.288"
                      cy="25.9912"
                      r="1.39737"
                      transform="rotate(-90 2.288 25.9912)"
                      fill="#3056D3"
                    />
                    <circle
                      cx="14.5849"
                      cy="25.9911"
                      r="1.39737"
                      transform="rotate(-90 14.5849 25.9911)"
                      fill="#3056D3"
                    />
                    <circle
                      cx="26.7216"
                      cy="25.9911"
                      r="1.39737"
                      transform="rotate(-90 26.7216 25.9911)"
                      fill="#3056D3"
                    />
                    <circle
                      cx="2.288"
                      cy="13.6944"
                      r="1.39737"
                      transform="rotate(-90 2.288 13.6944)"
                      fill="#3056D3"
                    />
                    <circle
                      cx="14.5849"
                      cy="13.6943"
                      r="1.39737"
                      transform="rotate(-90 14.5849 13.6943)"
                      fill="#3056D3"
                    />
                    <circle
                      cx="26.7216"
                      cy="13.6943"
                      r="1.39737"
                      transform="rotate(-90 26.7216 13.6943)"
                      fill="#3056D3"
                    />
                    <circle
                      cx="2.288"
                      cy="38.0087"
                      r="1.39737"
                      transform="rotate(-90 2.288 38.0087)"
                      fill="#3056D3"
                    />
                    <circle
                      cx="2.288"
                      cy="1.39739"
                      r="1.39737"
                      transform="rotate(-90 2.288 1.39739)"
                      fill="#3056D3"
                    />
                    <circle
                      cx="14.5849"
                      cy="38.0089"
                      r="1.39737"
                      transform="rotate(-90 14.5849 38.0089)"
                      fill="#3056D3"
                    />
                    <circle
                      cx="26.7216"
                      cy="38.0089"
                      r="1.39737"
                      transform="rotate(-90 26.7216 38.0089)"
                      fill="#3056D3"
                    />
                    <circle
                      cx="14.5849"
                      cy="1.39761"
                      r="1.39737"
                      transform="rotate(-90 14.5849 1.39761)"
                      fill="#3056D3"
                    />
                    <circle
                      cx="26.7216"
                      cy="1.39761"
                      r="1.39737"
                      transform="rotate(-90 26.7216 1.39761)"
                      fill="#3056D3"
                    />
                  </svg>
                </span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- ====== Forms Section End -->
  </div>
</template>

<script>
import Vue from "vue";
import VueAlertify from "vue-alertify";
Vue.use(VueAlertify);

import http from "../../common/axios.js";

export default {
  name: "Login",

  methods: {
    async login() {
      let loginObj = {
        userEmail: this.$store.state.login.userEmail,
        userPassword: this.$store.state.login.userPassword,
      };

      try {
        let { data } = await http.post("/login", loginObj);

        console.log("LoginVue: data : ");
        console.log(data);

        this.$store.commit("SET_LOGIN", {
          isLogin: true,
          userSeq: data.userSeq,
          userName: data.userName,
          userEmail: data.userEmail,
          userPassword: data.userPassword,
        });
        // HappyHouseMain으로 이동
        this.$router.push("/house");
      } catch (error) {
        console.log("LoginVue: error : ");
        console.log(error);
        if (error.response.status == "404") {
          this.$alertify.error("이메일 또는 비밀번호를 확인하세요.");
        } else {
          this.$alertify.error("Opps!! 서버에 문제가 발생했습니다.");
        }
      }
    },

    KakaoLogin() {
      console.log(window.Kakao);
      window.Kakao.Auth.login({
        scope: "account_email, profile_nickname, gender",
        success: this.GetMe,
        fail: function (error) {
          console.log(error);
        },
      });
    },

    GetMe(authObj) {
      console.log(authObj);
      window.Kakao.API.request({
        url: "/v2/user/me",
        success: (res) => {
          const kakao_account = res.kakao_account;

          http
            .post("/login", {
              userName: kakao_account.profile.nickname,
              userEmail: kakao_account.email,
              userPassword: "eh1120811!",
              userSeq: this.userSeq,
            })
            .then(({ data }) => {
              console.log("LoginVue: data : ");
              console.log(data);
              // login 성공 전달
              this.$store.commit("SET_LOGIN", {
                isLogin: true,
                userSeq: data.userSeq,
                userName: data.userName,
                userEmail: data.userEmail,
                userPassword: data.userPassword,
              });
              this.$store.commit("SET_KAKAO");
              this.$alertify.success(
                this.$store.state.login.userName + "님 환영합니다"
              );

              this.$router.push("/house");
            })
            .catch((error) => {
              console.log("KaKaoLoginVue: error : ");
              console.log(error);
              if (error.response.status == "404") {
                // => 카카오 회원가입
                http
                  .post("/register", {
                    userName: kakao_account.profile.nickname,
                    userEmail: kakao_account.email,
                    userPassword: "eh1120811!",
                  })
                  .then(({ data }) => {
                    console.log("RegisterVue - data : ");
                    console.log(data);
                    // register 성공 전달
                    this.$store.commit("SET_LOGIN", {
                      isLogin: true,
                      userSeq: data.userSeq,
                      userName: data.userName,
                      userEmail: data.userEmail,
                      userPassword: data.userPassword,
                    });

                    this.$store.commit("SET_KAKAO");
                    this.$alertify.success(
                      this.$store.state.login.userName + "님 환영합니다"
                    );

                    this.$router.push("/house");
                  })
                  .catch((error) => {
                    console.log("LoginVue: error : ");
                    console.log(error);
                    if (error.response.status == "404") {
                      this.$alertify.error("카카오 로그인에 실패했습니다.");
                    } else {
                      this.$alertify.error(
                        "Opps!! 서버에 문제가 발생했습니다."
                      );
                    }
                  });
              } else {
                this.$alertify.error("Opps!! 서버에 문제가 발생했습니다.");
              }
            });
        },
        fail: (error) => {
          this.$router.push("/");
          console.log(error);
        },
      });
    },
  },
  mounted() {},
};
</script>

<style>
.login {
  margin-top: 150px;
  margin-bottom: 0px;
}
</style>
