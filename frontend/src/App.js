import styled from "styled-components";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import Login from "./pages/Login";
import Register from "./pages/Register";
import Board from "./pages/Board";
import BoardDetail from "./components/Board/BoardDetail";
import MyPage from "./pages/MyPage";
import Auth from "./hoc/auth";

const Container = styled.div`
  margin: 10px auto;
  width: 370px;
`;

function App() {
  return (
    <Container>
      <Router>
        <Switch>
          <Route exact path="/" component={Login} />
          <Route path="/register" component={Register} />
          <Route path="/board" component={Board} />
          <Route path="/board/:boardId" component={BoardDetail} />
          <Route path="/mypage" component={MyPage} />
        </Switch>
      </Router>
    </Container>
  );
}

export default App;
