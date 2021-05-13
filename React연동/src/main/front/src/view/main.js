import React from 'react';
//import { Router, Link } from 'react-router-dom';
import './style.css';
//이미지 업로드
import Logo from './image/mainweb_logo.png'
import Cake from './image/mainweb_imgcake.png'
import Line from './image/mainweb_heartline.png'
import Box from './image/mainweb_imgbox.png'
import Event1 from './image/mainweb_event1.png'
import Event2 from './image/mainweb_event2.png'
import Notice from './image/mainweb_noticetitle.png'
import Top from './image/mainweb_btnup.png'

function Main() {
    return (
      <div className="main">
        <div className="header" name="top">
          <div className="header-logo">
            <img src={Logo} />
          </div>
          <div className="header-menu">
            <a className="hidden" href="#introduce">행사소개</a>
            <a href="#test">애정도 테스트</a>
            <a href="#comment">생일축하 한마디</a>
            <a href="#notice">공지</a>
          </div>
        </div>

        <div className="container">
          <div className="container-introduce">
            <a name="introduce">
              <img src={Cake} />
              <p>
                생일 축하합니다~ 생일 축하합니다~ <br/>
                사랑하는 이화이언의 생일 축하합니다! <br/>
                여러분! 어느새 이화이언이 20번째 생일을 맞이하였다는 사실, <br className="hidden"/>
                알고 계셨나요?
              </p>
              <p>
                올해는 <span>이화이언 20주년</span>을 맞이하여, <br/>
                특별한 테스트와 이벤트를 준비했습니다!
              </p>
              <img className="introduce_line" src={Line} />
              <img src={Box} />
              <p>
                추첨을 통해 소장욕구 뿜뿜하는 이화이언의 생일 굿즈를 선물해드리니 <br/>
                많은 참여 부탁드리며 <span>이화이언 생일 축하</span>도 잊지 마세요! <br className="hidden"/>
                감사합니다
              </p>
              <p className="introduce_extra">
                *생일 굿즈는 이화이언 공식 인스타그램에서 확인해주세요.
              </p>
            </a>
          </div>
          <div className="container-testcomment">
            <a name="test">
              <a href="http://www.ewhaian.com/" className="event1"><img src={Event1} /></a>
            </a>
            <a name="comment">
              <a href="http://www.ewhaian.com/" className="event2"><img src={Event2} /></a>
            </a>
          </div>
          <div className="container-notice">
            <a name="notice">
              <img src={Notice} />
              <ul>
                <li>
                  <div>
                    <h6>공지1</h6>
                    <p className="notice_p">공지 본문입니다.</p>
                  </div>
                </li>
                <li>
                  <div>
                    <h6>공지2</h6>
                    <p className="notice_p">공지 본문입니다.</p>
                  </div>
                </li>
              </ul>
            </a>
          </div>

          <div className="top">
            <a href="#top"><img src={Top} /></a>
          </div>

          <div className="footer">
            @2021. Ewhaian. All rights reserved.
          </div>
        </div>
      </div>
    );
  }
  
  export default Main;