package cs310davis.donor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * DonorBinaryTree Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Aug 7, 2016</pre>
 */
public class DonorBinaryTreeTest {
  static DonorBinaryTree donorBinaryTree;
  static Donor donor = new Donor(1000, "Sam", "Davis", "315-281-5502", "sam.davis@techngs.com",true);

  @Before
  public void before() throws Exception {
    donorBinaryTree = new DonorBinaryTree();
  }

  /**
   * Method: addNode(Donor donor)
   */
  @Test
  public void testAddNode() throws Exception {
    donorBinaryTree.addNode(donor);
    Assert.assertTrue(donorBinaryTree.findDonorInTree(donor.getDonorId())!= null);
  }

  /**
   * Method: traverseTreeInOrder(DonorNode donorNode)
   */
  @Test
  public void testTraverseTreeInOrder() throws Exception {
    donorBinaryTree.addNode(donor);
    donorBinaryTree.traverseTreeInOrder(donorBinaryTree.getRootOfTree());
  }

  /**
   * Method: findDonorInTree(int donorId)
   */
  @Test
  public void testFindDonorInTree() throws Exception {
    donorBinaryTree.addNode(donor);
    Assert.assertTrue(donorBinaryTree.findDonorInTree(donor.getDonorId())!= null);
  }

  /**
   * Method: remove(int donorId)
   */
  @Test
  public void testRemoveSuccess() throws Exception {
    donorBinaryTree.addNode(donor);
    Assert.assertTrue(donorBinaryTree.remove(donor.getDonorId()));
  }


  /**
   * Method: getRootOfTree()
   */
  @Test
  public void testGetRootOfTree() throws Exception {
    donorBinaryTree.addNode(donor);
    Assert.assertNotNull(donorBinaryTree.getRootOfTree());

  }


}
