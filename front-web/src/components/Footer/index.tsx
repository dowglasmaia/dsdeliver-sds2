import "./styles.css"

import { ReactComponent as YoutubeImg } from './imgs/youtube.svg';
import { ReactComponent as InstagramImg } from './imgs/instagram.svg';
import { ReactComponent as LinkedinImg } from './imgs/linkedin.svg';

function Footer() {
    return (
        <footer className="main-footer">
            App desenvolvido durante a 2ª ed. do evento Semana DevSuperior.

            <div className="footer-icons">
                <a href="#" target="_new" >
                    <YoutubeImg/>
                </a>
                <a href="www.linkedin.com/in/dowglasmaia" target="_new" >
                    <LinkedinImg/>
                </a>
                <a href="#" target="_new" >
                    <InstagramImg/>
                </a>
            </div>
        </footer>
    )

}
export default Footer;