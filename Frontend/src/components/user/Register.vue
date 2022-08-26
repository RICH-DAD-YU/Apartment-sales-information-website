<template>
  <div class="register">
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
                    src="../../../public/assets/images/logo/logo_signup.png"
                    alt="logo"
                  />
                </a>
              </div>
              <form>
                <div class="mb-6">
                  <input
                    type="name"
                    placeholder="Name"
                    :class="{
                      'is-valid': isUserNameFocusAndValid,
                      'is-invalid': isUserNameFocusAndInvalid,
                    }"
                    v-model="userName"
                    @input="validateUserName"
                    @focus="isUserNameFocus = true"
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
                  <div class="valid-feedback">Valid.</div>
                  <div class="invalid-feedback">
                    올바른 이름을 입력해 주세요.
                  </div>
                </div>
                <div class="mb-6">
                  <input
                    type="email"
                    placeholder="Email"
                    :class="{
                      'is-valid': isUserEmailFocusAndValid,
                      'is-invalid': isUserEmailFocusAndInValid,
                    }"
                    v-model="userEmail"
                    @input="validateEmail"
                    @focus="isUserEmailFocus = true"
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
                  <div class="valid-feedback">Valid.</div>
                  <div class="invalid-feedback">
                    올바른 Email 을 입력해 주세요.
                  </div>
                </div>
                <div class="mb-6">
                  <input
                    type="password"
                    placeholder="Password"
                    :class="{
                      'is-valid': isUserPasswordFocusAndValid,
                      'is-invalid': isUserPasswordFocusAndInvalid,
                    }"
                    v-model="userPassword"
                    @input="validatePassword"
                    @focus="isUserPasswordFocus = true"
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
                  <div class="valid-feedback">Valid.</div>
                  <div class="invalid-feedback">
                    1개 이상의 특수문자, 대소문자 및 숫자를 포함하고 8자리
                    이상이여야 합니다.
                  </div>
                </div>
                <div class="mb-6">
                  <input
                    type="password"
                    placeholder="Confirm Password"
                    :class="{
                      'is-valid': isUserPassword2FocusAndValid,
                      'is-invalid': isUserPassword2FocusAndInvalid,
                    }"
                    v-model="userPassword2"
                    @input="validatePassword2"
                    @focus="isUserPassword2Focus = true"
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
                  <div class="valid-feedback">Valid.</div>
                  <div class="invalid-feedback">
                    비밀번호가 일치하지 않습니다.
                  </div>
                </div>
                <div class="mb-10">
                  <div>
                    <button
                      @click.self.prevent="register"
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
                      Sign Up
                    </button>
                  </div>
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
                Already have an account?
                <router-link
                  to="/login"
                  class="hover:underline"
                  style="color: #786d64"
                >
                  Log In
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
  </div>
</template>

<script>
import Vue from "vue";
import VueAlertify from "vue-alertify";
Vue.use(VueAlertify);

import http from "../../common/axios.js";

export default {
  // data 사용 X
  data() {
    return {
      // v-model
      userName: "",
      userEmail: "",
      userPassword: "",
      userPassword2: "",

      // focus
      isUserNameFocus: false,
      isUserEmailFocus: false,
      isUserIdFocus: false,
      isUserPasswordFocus: false,
      isUserPassword2Focus: false,

      // validation
      isUserNameValid: false,
      isUserIdValid: false,
      isUserEmailValid: false,
      isUserPasswordValid: false,
      isUserPassword2Valid: false,
    };
  },
  computed: {
    isUserNameFocusAndValid() {
      return this.isUserNameFocus && this.isUserNameValid;
    },
    isUserNameFocusAndInvalid() {
      return this.isUserNameFocus && !this.isUserNameValid;
    },
    isUserIdFocusAndValid() {
      return this.isUserIdFocus && this.isUserIdValid;
    },
    isUserIdFocusAndInvalid() {
      return this.isUserIdFocus && !this.isUserIdValid;
    },
    isUserEmailFocusAndValid() {
      return this.isUserEmailFocus && this.isUserEmailValid;
    },
    isUserEmailFocusAndInValid() {
      return this.isUserEmailFocus && !this.isUserEmailValid;
    },
    isUserPasswordFocusAndValid() {
      return this.isUserPasswordFocus && this.isUserPasswordValid;
    },
    isUserPasswordFocusAndInvalid() {
      return this.isUserPasswordFocus && !this.isUserPasswordValid;
    },
    isUserPassword2FocusAndValid() {
      return this.isUserPassword2Focus && this.isUserPassword2Valid;
    },
    isUserPassword2FocusAndInvalid() {
      return this.isUserPassword2Focus && !this.isUserPassword2Valid;
    },
  },
  methods: {
    validateUserName() {
      this.isUserNameValid = this.userName.length > 0 ? true : false;
      console.log(this.isUserNameValid);
    },
    validateEmail() {
      // ^ 시작일치, $ 끝 일치
      // {2, 3} 2개 ~ 3개
      // * 0회 이상, + 1회 이상
      // [-_.] - 또는 _ 또는 .
      // ? 없거나 1회
      let regexp =
        /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
      this.isUserEmailValid = regexp.test(this.userEmail) ? true : false;
      console.log(this.isUserEmailValid);
    },
    validatePassword() {
      let patternEngAtListOne = new RegExp(/[a-zA-Z]+/); // + for at least one
      let patternSpeAtListOne = new RegExp(/[~!@#$%^&*()_+|<>?:{}]+/); // + for at least one
      let patternNumAtListOne = new RegExp(/[0-9]+/); // + for at least one

      this.isUserPasswordValid =
        patternEngAtListOne.test(this.userPassword) &&
        patternSpeAtListOne.test(this.userPassword) &&
        patternNumAtListOne.test(this.userPassword) &&
        this.userPassword.length >= 8
          ? true
          : false;
    },
    validatePassword2() {
      this.isUserPassword2Valid =
        this.userPassword == this.userPassword2 ? true : false;
    },
    async register() {
      if (
        !this.isUserEmailValid ||
        !this.isUserPasswordValid ||
        !this.isUserPassword2Valid
      )
        return;

      let registerObj = {
        userName: this.userName,
        userEmail: this.userEmail,
        userPassword: this.userPassword,
      };
      try {
        console.log(registerObj);
        let { data } = await http.post("/register", registerObj); // JSON Request, { params : registerObj } X params 를 쓰면 get => query string
        console.log("RegisterVue: data : ");

        if (data.result == "success") {
          let $this = this;
          this.$alertify.alert(
            "회원가입을 축하합니다. 로그인 페이지로 이동합니다",
            function () {
              $this.$router.push("/login");
            }
          );
        } else {
          console.log("RegisterVue: error : ");
          this.$alertify.error("서버에 문제가 발생했습니다.");
        }
      } catch (error) {
        console.log("RegisterVue: error : ");
        console.log(error);
        this.$alertify.error("서버에 문제가 발생했습니다.");
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

    async GetMe(authObj) {
      console.log(authObj);
      window.Kakao.API.request({
        url: "/v2/user/me",
        success: (res) => {
          const kakao_account = res.kakao_account;
          console.log(kakao_account.profile.nickname);

          http
            .post("/login", {
              userName: kakao_account.profile.nickname,
              userEmail: kakao_account.email,
              userSeq: this.userSeq,
              userPassword: "eh1120811!",
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
              this.$alertify.success(
                this.$store.state.login.userName + "님 환영합니다"
              );

              this.$router.push("/house");
            })
            .catch((error) => {
              console.log("KaKaoLoginVue: error : ");
              console.log(error);

              console.log(kakao_account.profile.nickname);
              if (error.response.status == "404") {
                // => 카카오 회원가입
                http
                  .post("/register", {
                    userName: kakao_account.profile.nickname,
                    userEmail: kakao_account.email,
                    userSeq: this.userSeq,
                    userPassword: "eh1120811!",
                  })

                  .then(({ data }) => {
                    console.log("RegisterVue - data : ");
                    console.log(data);
                    // register 성공 전달
                    this.$store.commit("SET_LOGIN", {
                      isLogin: true,
                      userSeq: data.userSeq,
                      userName: data.profile.nickname,
                      userEmail: data.email,
                      userPassword: data.userPassword,
                    });
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
          this.$router.push("/house");
          console.log(error);
        },
      });
    },
  },
};
</script>

<style>
.register {
  margin-top: 150px;
  margin-bottom: 0px;
}
</style>
