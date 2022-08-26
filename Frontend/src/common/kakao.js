const Kakao = {
  init() {
    window.Kakao.init(process.env.bed69a574ff3dcf83359fea03df370d6);
  },

  GetMe(authObj) {
    console.log(authObj);
    widow.Kako.API.request({
      url: "/oauth",
      sucess: async (res) => {
        console.log(res);
        const kakao_acount = res.kakao_acount;
        const req_body = {
          name: kakao_acount.profile.nickname,
          email: kakao_acount.email,
          kakaoAccessToken: authObj.access_token,
          source: "k",
        };
        social_login(req_body);
      },
      fail: (error) => {
        LoginFailure();
        console.log(error);
      },
    });
  },

  Login() {
    console.log(window.Kakao);
    window.Kakao.Auth.login({
      scope: "account_email, gender",
      sucess: this.GetMe,
      fail: LoginFailure,
    });
  },

  Logout() {
    window.Kakao.Auth.logout((res) => {
      if (!res) return LoginFailure();
      social_logout();
    });
  },
};

export default Kakao;
