import { FC } from "react";
import Button from "react-bootstrap/Button";
import Modal from "react-bootstrap/Modal";

interface IProps {
  show: boolean;
  header: string;
  content: string;
  buttonText: string;
  closeHandler?: () => void;
}

const AppModal: FC<IProps> = ({
  show,
  header,
  content,
  buttonText,
  closeHandler,
}) => {
  return (
    <>
      <Modal show={show} onHide={closeHandler}>
        <Modal.Header closeButton>
          <Modal.Title>{header}</Modal.Title>
        </Modal.Header>
        <Modal.Body>{content}</Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={closeHandler}>
            {buttonText}
          </Button>
        </Modal.Footer>
      </Modal>
    </>
  );
};

export default AppModal;
